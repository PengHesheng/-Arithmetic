package acm;

/**
 * 贪心算法
 * @author 14512 on 2018/9/15.
 */
public class Greedy {

    public static void main(String[] args) {
        question1();
    }

    /**
     * 问题描述：有1元、5元、10元、50元、100元、500元的硬币各
     * C1、C5、C10、C50、C100、C500枚，现用这些来支付A元，最少需要多少枚硬币
     * 假设至少存在一种方案
     *
     * 0 <= C1,C5,C10,C50,C100,C500 <= 10^9
     * 0 <= A <= 10^9
     */
    private static void question1() {
        //硬币的面值
        int[] V = new int[]{1, 5, 10, 50, 100, 500};
        //输入 C1=3, C5=2, C10=1, C50=3, C100=0, C500=2, A=620
        //输出 6(500x1, 20x2, 10x1, 5x2)
        int[] C = new int[]{3, 2, 1, 3, 0, 2};
        int A= 620;

        int count = 0;
        for (int i = 5; i >= 0; i--) {
            int t = Math.min(A / V[i], C[i]);
            A -= t * V[i];
            count += t;
        }
        System.out.println(count);
    }
}
