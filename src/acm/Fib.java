package acm;

/**
 * 斐波那契数列
 * F(0)=0，F(1)=(1)，F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）
 * @author 14512 on 2018/9/13.
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(fib(30));
        System.out.println(System.currentTimeMillis());
        System.out.println(fib1(30));
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 常规写法
     * @param n n >= 0
     * @return
     */
    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 数组大小
     */
    private static int MAX_N = 100;
    private static int[] memo = new int[MAX_N + 1];

    /**
     * 利用多一个空间来减少重复计算
     * 效率更高
     * @param n n >= 0
     * @return
     */
    private static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = fib1(n - 1) + fib1(n - 2);
    }
}
