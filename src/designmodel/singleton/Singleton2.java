package designmodel.singleton;

/**
 * 线程安全的懒汉式
 * @author 14512 on 2019/3/27.
 */
public class Singleton2 {
    private static Singleton2 mInstance;
    private Singleton2() {}

    public static synchronized Singleton2 getInstance() {
        if (mInstance == null) {
            mInstance = new Singleton2();
        }
        return mInstance;
    }
}
