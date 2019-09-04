package designmodel.product_consumer;

/**
 * @author PHS1024
 * @date 2019/9/4 16:09
 */
public class ProductConsumer {

    public static void main(String[] args) {
        Object lock = new Object();
        Product product = new Product(lock);
        Consumer consumer = new Consumer(lock);
        ProductThread productThread = new ProductThread(product);
        ConsumerThread consumerThread = new ConsumerThread(consumer);
        productThread.start();
        consumerThread.start();
    }
}

class Product {
    private Object mLock;

    public Product(Object lock) {
        this.mLock = lock;
    }

    public void setValue() {
        try {
            synchronized (mLock) {
                if (!StringObject.value.isEmpty()) {
                    mLock.wait();
                }
                String value = System.currentTimeMillis() + "" + System.nanoTime();
                System.out.println("product:" + value);
                StringObject.value = value;
                mLock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer {
    private Object mLock;

    public Consumer(Object lock) {
        this.mLock = lock;
    }

    public void getValue() {
        try {
            synchronized (mLock) {
                if (StringObject.value.isEmpty()) {
                    mLock.wait();
                }
                System.out.println("consumer:" + StringObject.value);
                StringObject.value = "";
                mLock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class ProductThread extends Thread {
    private Product mProduct;

    public ProductThread(Product product) {
        this.mProduct = product;
    }

    @Override
    public void run() {
        while (true) {
            mProduct.setValue();
        }
    }
}

class ConsumerThread extends Thread {
    private Consumer mConsumer;

    public ConsumerThread(Consumer consumer) {
        this.mConsumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            mConsumer.getValue();
        }
    }
}

class StringObject {
    public static String value = "";
}