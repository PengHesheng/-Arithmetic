package designmodel.state;

/**
 * 电视状态接口，定义电视操作函数
 * @author PHS
 * @create 2019-04-23 10:36
 **/
public interface ITvController {
    /**
     * 下一个
     */
    void nextChannel();

    /**
     * 上一个频道
     */
    void prevChannel();

    /**
     * 调高音量
     */
    void turnUp();

    /**
     * 调低音量
     */
    void turnDown();
}
