package designmodel.strategy;

/**
 * 抽象的计算价格接口
 * @author PHS
 * @create 2019-04-21 09:41
 **/
public interface CalculateStrategy {
    /**
     * 按距离来计算价格
     * @param km
     * @return
     */
    int calculatePrice(int km);
}
