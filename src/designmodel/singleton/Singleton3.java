package designmodel.singleton;

/**
 * 饿汉式
 * @author 14512 on 2019/3/27.
 */
public class Singleton3 {
    private static Singleton3 mInstance = new Singleton3();
    private Singleton3() {}

    public static Singleton3 getInstance() {
        return mInstance;
    }
}
