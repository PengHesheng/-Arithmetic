package designmodel.singleton;

/**
 * 单例模式 懒汉模式
 * @author 14512 on 2019/3/27.
 */
public class Singleton1 {
    private static Singleton1 mInstance;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (mInstance == null) {
            mInstance = new Singleton1();
        }
        return mInstance;
    }

}