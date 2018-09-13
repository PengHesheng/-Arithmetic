package acm;

/**
 * 深度优先遍历算法
 * @author 14512 on 2018/9/13.
 */
public class DFS {



    public static void main(String[] args) {
        solve();
        solveLake();
    }

    /**
     * 问题描述：有一个NxM的园子，雨后积水，八连通的积水认为连在一起，
     * 请问园子里有多少处水洼？
     *
     * 八连通：
     *   ***
     *   *W*
     *   ***
     *
     *  N,M <= 100
     */
    private static int N, M;
    private static char[][] filed;
    private static void solveLake() {
        //输入
        N = 10;
        M =12;
        filed = new char[][]{
            {'W', '.', '.', '.', '.', '.', '.', '.', '.', 'W', 'W', '.'},
            {'.', 'W', 'W', 'W', '.', '.', '.', '.', '.', 'W', 'W', 'W'},
            {'.', '.', '.', '.', 'W', 'W', '.', '.', '.', 'W', 'W', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', 'W', 'W', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', 'W', '.', '.'},
            {'.', '.', 'W', '.', '.', '.', '.', '.', '.', 'W', '.', '.'},
            {'.', 'W', '.', 'W', '.', '.', '.', '.', '.', 'W', 'W', '.'},
            {'W', '.', 'W', '.', 'W', '.', '.', '.', '.', '.', 'W', '.'},
            {'.', 'W', '.', 'W', '.', '.', '.', '.', '.', '.', 'W', '.'},
            {'.', '.', 'W', '.', '.', '.', '.', '.', '.', '.', 'W', '.'}

        };
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (filed[i][j] == 'W') {
                    dfs2(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs2(int x, int y) {
        //将所在位置替换为.
        filed[x][y] = '.';
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = x + dx;
                int ny = y + dy;
                //判断（nx，ny）是不是在园子内，以及是否有积水
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && filed[nx][ny] == 'W') {
                    dfs2(nx, ny);
                }
            }
        }
    }


    /**
     * 问题描述：给定整数a1、a2、...、an，判断是否可以从中选取若干数，使它们的和恰好为k
     * 1 <= n <= 20
     * -10^8 <= a1 <= 10^8
     * 10^8 <= k <= 10^8
     */
    private static int[] a1;
    private static int n, k;
    private static void solve() {
        //输入a1
        a1 = new int[]{1,2,4,7};
        n = 4;
        k = 13;
        if (dfs1(0, 0)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static boolean dfs1(int i, int sum) {
        //如果前n项都计算过了，则返回sum是否=k
        if (i == n) {
            return sum == k;
        }

        //不加上a[i]的情况
        if (dfs1(i + 1, sum)) {
            return true;
        }

        //加上a[i]的情况
        if (dfs1(i + 1, sum + a1[i])) {
            return true;
        }

        //无论是否加上a[i]的情况都不能满足
        return false;
    }
}
