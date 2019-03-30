package designmodel.singleton;

/**
 * 内部类形式
 * @author 14512 on 2019/3/27.
 */
public class Singleton5 {

    private Singleton5() {}

    private static class InnerClass {
        private final static Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return InnerClass.INSTANCE;
    }
}
