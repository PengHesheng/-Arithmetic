package designmodel.strategy;

/**
 * @author PHS
 * @create 2019-04-21 09:41
 **/
public class BusStrategy implements CalculateStrategy {

    /**
     * 十公里内 1元 超过十公里之后每加1元可乘5公里
     * @param km 公里
     * @return price
     */
    @Override
    public int calculatePrice(int km) {
        //超过十公里的距离
        int extraTotal = km - 10;
        int extraFactor = extraTotal / 5;
        int fraction = extraTotal % 5;
        //计算价格
        int price = 1 + extraFactor * 1;
        return fraction > 0 ? ++price : price;
    }
}
