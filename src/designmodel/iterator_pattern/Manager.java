package designmodel.iterator_pattern;

/**
 * @author PHS
 * @create 2019-04-23 11:02
 **/
public class Manager extends Leader {
    @Override
    public int limit() {
        return 10000;
    }

    @Override
    public void handle(int money) {
        System.out.println("manager handle " + money);
    }
}
