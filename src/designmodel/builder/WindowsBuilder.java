package designmodel.builder;

/**
 * @author 14512 on 2019/3/30.
 */
public class WindowsBuilder extends BaseBuilder {
    private BaseComputer mComputer = new Windows();

    @Override
    public BaseBuilder buildBoard(String board) {
        mComputer.mBoard = board;
        return this;
    }

    @Override
    public BaseBuilder buildDisplay(String display) {
        mComputer.mDisplay = display;
        return this;
    }

    @Override
    public BaseBuilder buildOS() {
        mComputer.setOS();
        return this;
    }

    @Override
    public BaseComputer create() {
        return mComputer;
    }
}

class Windows extends BaseComputer {
    protected Windows() {

    }

    @Override
    public void setOS() {
        mOS = "Windows";
    }
}

abstract class BaseComputer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOS;

    protected BaseComputer() { }

    public void setDisplay(String display) {
        this.mDisplay = display;
    }

    public void setBoard(String board) {
        this.mBoard = board;
    }

    public abstract void setOS();
}

abstract class BaseBuilder {
    public abstract BaseBuilder buildBoard(String board);

    public abstract BaseBuilder buildDisplay(String display);

    public abstract BaseBuilder buildOS();

    public abstract BaseComputer create();
}
