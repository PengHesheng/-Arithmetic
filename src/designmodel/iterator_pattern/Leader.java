package designmodel.iterator_pattern;

/**
 * 抽象领导者
 * @author PHS
 * @create 2019-04-23 10:56
 **/
public abstract class Leader {
    /**
     * 上一级领导处理者
     */
    protected Leader nextHandler;

    public final void handleRequest(int money) {
        if (money <= limit()) {
            handle(money);
        } else {
            if (nextHandler != null) {
                //交给自己的上级处理
                nextHandler.handleRequest(money);
            } else {
                System.out.println("无人处理");
            }
        }
    }

    /**
     * 自身能皮肤的额度权限
     * @return 额度
     */
    public abstract int limit();

    /**
     * 处理报账行为
     * @param money
     */
    public abstract void handle(int money);
}
