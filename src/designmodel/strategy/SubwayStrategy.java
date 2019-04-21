package designmodel.strategy;

/**
 * @author PHS
 * @create 2019-04-21 09:43
 **/
public class SubwayStrategy implements CalculateStrategy {
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
