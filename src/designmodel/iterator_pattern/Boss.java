package designmodel.iterator_pattern;

/**
 * @author PHS
 * @create 2019-04-23 11:02
 **/
public class Boss extends Leader {
    @Override
    public int limit() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void handle(int money) {
        System.out.println("boss handle " + money);
    }
}
