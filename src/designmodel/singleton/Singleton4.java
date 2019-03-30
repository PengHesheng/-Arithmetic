package designmodel.singleton;

/**
 * DCL
 * @author 14512 on 2019/3/27.
 */
public class Singleton4 {
    private static Singleton4 mInstance;
    private Singleton4() {}

    public static Singleton4 getInstance() {
        if (mInstance == null) {
            synchronized (Singleton4.class) {
                if (mInstance == null) {
                    mInstance = new Singleton4();
                }
            }
        }
        return mInstance;
    }

}
