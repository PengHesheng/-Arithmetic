package designmodel.strategy;

/**
 * 策略者模式
 * @author PHS
 * @create 2019-04-21 09:35
 **/
public class PriceCalculator {

    public static void main(String[] args) {

    }

    ICalculateStrategy mStrategy;

    public void setmStrategy(ICalculateStrategy mStrategy) {
        this.mStrategy = mStrategy;
    }

    public int calculatePrice(int km) {
        //依赖抽象
        return mStrategy.calculatePrice(km);
    }

    /*-----------------------------------------------不使用策略者模式的写法  ----------------------------------------*/
    /**
     * 十公里内 1元 超过十公里之后每加1元可乘5公里
     * @param km 公里
     * @return price
     */
    private int busPrice(int km) {
        //超过十公里的距离
        int extraTotal = km - 10;
        int extraFactor = extraTotal / 5;
        int fraction = extraTotal % 5;
        //计算价格
        int price = 1 + extraFactor * 1;
        return fraction > 0 ? ++price : price;
    }

    /**
     * 6公里内3元 6~12公里4元 12~22公里5元 22~32公里6元
     * @param km
     * @return
     */
    public int subwayPrice(int km) {
        if (km <= 6) {
            return 3;
        } else if (km <= 12) {
            return 4;
        } else if (km <= 22) {
            return 5;
        } else if (km <= 32) {
            return 6;
        } else {
            return 7;
        }
    }
}

/**
 * 抽象的计算价格接口
 **/
interface ICalculateStrategy {
    /**
     * 按距离来计算价格
     * @param km
     * @return
     */
    int calculatePrice(int km);
}

class BusStrategy implements ICalculateStrategy {

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

class SubwayStrategy implements ICalculateStrategy {
    private static final int DISTANCE_6 = 6;
    private static final int DISTANCE_12 = 12;
    private static final int DISTANCE_22 = 22;
    private static final int DISTANCE_32 = 32;

    /**
     * 6公里内3元 6~12公里4元 12~22公里5元 22~32公里6元
     * @param km
     * @return
     */
    @Override
    public int calculatePrice(int km) {
        if (km <= DISTANCE_6) {
            return 3;
        } else if (km <= DISTANCE_12) {
            return 4;
        } else if (km <= DISTANCE_22) {
            return 5;
        } else if (km <= DISTANCE_32) {
            return 6;
        } else {
            return 7;
        }
    }
}