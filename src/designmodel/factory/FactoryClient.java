package designmodel.factory;

/**
 * @author PHS
 * @create 2019-04-25 11:54
 **/
public class FactoryClient {

}

abstract class Product {

    public abstract void method();
}

class ProductA extends Product {
    @Override
    public void method() {
        System.out.println("product A");
    }
}

class ProductB extends Product {
    @Override
    public void method() {
        System.out.println("product B");
    }
}

