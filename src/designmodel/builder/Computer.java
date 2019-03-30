package designmodel.builder;

/**
 * @author 14512 on 2019/3/30.
 */
public abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOS;

    protected Computer() { }

    public void setDisplay(String display) {
        this.mDisplay = display;
    }

    public void setBoard(String board) {
        this.mBoard = board;
    }

    public abstract void setOS();
}
