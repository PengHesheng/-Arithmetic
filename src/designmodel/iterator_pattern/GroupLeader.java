package designmodel.iterator_pattern;

/**
 *
 * @author PHS
 * @create 2019-04-23 11:00
 **/
public class GroupLeader extends Leader {
    @Override
    public int limit() {
        return 1000;
    }

    @Override
    public void handle(int money) {
        System.out.println("group leader handle " + money);
    }
}
