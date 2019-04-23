package designmodel.state;

/**
 * 开机状态下
 * @author PHS
 * @create 2019-04-23 10:39
 **/
public class PowerOnState implements ITvController {
    @Override
    public void nextChannel() {
        System.out.println("下一频道");
    }

    @Override
    public void prevChannel() {
        System.out.println("上一个频道");
    }

    @Override
    public void turnUp() {
        System.out.println("+音量");
    }

    @Override
    public void turnDown() {
        System.out.println("-音量");
    }
}
