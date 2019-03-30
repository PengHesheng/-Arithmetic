package designmodel.builder;

/**
 * @author 14512 on 2019/3/30.
 */
public class WindowsBuilder extends Builder {
    private Computer mComputer = new Windows();

    @Override
    public Builder buildBoard(String board) {
        mComputer.mBoard = board;
        return this;
    }

    @Override
    public Builder buildDisplay(String display) {
        mComputer.mDisplay = display;
        return this;
    }

    @Override
    public Builder buildOS() {
        mComputer.setOS();
        return this;
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
