package designmodel.iterator_pattern;

/**
 * @author PHS
 * @create 2019-04-23 11:03
 **/
public class Test {

    public static void main(String[] args) {
        GroupLeader groupLeader = new GroupLeader();
        Director director = new Director();
        Manager manager = new Manager();
        Boss boss = new Boss();
        groupLeader.nextHandler = director;
        director.nextHandler = manager;
        manager.nextHandler = boss;

        groupLeader.handleRequest(50000);
    }
}
