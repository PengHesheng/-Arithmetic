package designmodel.state;

/**
 * 关机状态应该是个空实现，所有功能无法使用
 * @author PHS
 * @create 2019-04-23 10:38
 **/
public class PowerOffState implements ITvController {
    @Override
    public void nextChannel() {

    }

    @Override
    public void prevChannel() {

    }

    @Override
    public void turnUp() {

    }

    @Override
    public void turnDown() {

    }
}
