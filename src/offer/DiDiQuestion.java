package offer;

import java.util.*;

/**
 * @author PHS1024
 * @date 2019/8/27 19:27
 */
public class DiDiQuestion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n < 1 || m < 1 || n > 1000 || m > 1000) {
            return;
        }
        int[][] A = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = scanner.nextInt();
                if (num < 1 || num > 1000) {
                    return;
                }
                A[i][j] = num;
            }
        }
        int[] max = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = A[i][j];
                if (max[j] == 0 || max[j] < num) {
                    max[j] = num;
                }
            }
        }
        int sum = 0;
        for (int value : max) {
            sum += value;
        }
        System.out.println(sum);
    }
}
