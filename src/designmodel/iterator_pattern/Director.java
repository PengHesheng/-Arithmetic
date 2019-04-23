package designmodel.iterator_pattern;

/**
 * @author PHS
 * @create 2019-04-23 11:01
 **/
public class Director extends Leader {
    @Override
    public int limit() {
        return 5000;
    }

    @Override
    public void handle(int money) {
        System.out.println("director handle " + money);
    }
}
