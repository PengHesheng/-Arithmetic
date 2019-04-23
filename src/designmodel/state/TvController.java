package designmodel.state;

/**
 * @author PHS
 * @create 2019-04-23 10:42
 **/
public class TvController implements IPowerContoller, ITvController {
    private ITvController mITvController;

    private void setTvState(ITvController mITvController) {
        this.mITvController = mITvController;
    }

    @Override
    public void powerOn() {
        setTvState(new PowerOnState());

    }

    @Override
    public void powerOff() {
        setTvState(new PowerOffState());
    }

    @Override
    public void nextChannel() {
        mITvController.nextChannel();
    }

    @Override
    public void prevChannel() {
        mITvController.prevChannel();
    }

    @Override
    public void turnUp() {
        mITvController.turnUp();
    }

    @Override
    public void turnDown() {
        mITvController.turnDown();
    }

}
