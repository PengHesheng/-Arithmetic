package offer;

import java.util.Scanner;

/**
 * @author PHS1024
 * @date 2019/8/24 19:38
 */
public class JDQuestion {

    public static void main(String[] args) {
        fun();
    }

    /**
     * 消消乐是当下十分火爆的一个脑力游戏。
     *
     * 游戏是这样的，有一个5*5的正方形网格，每个格子中有一个大于0且小于4的整数，对于一个确定的局面，若一个格子与它上下左右四个方向的某个格子（如果存在） 数字相同，则称这两个格子是连通的，并且这种连通具有传递性
     *
     * 每次，你可以选择一个格子，若与这个格子连通的格子（包括自己）数大于等于 3，你就可以选择消掉这个格子，与此同时，与这个格子连通的所有格子会一起消失
     *
     * 如果仅仅是这样，那太简单了，因为无论如何消，最后的结果都是一样的，所以我 们引入了重力系统，每次选择消掉某个格子，并将与那个格子相连通的所有格子都消掉后将会有一些格子失去支撑，此时那些格子就会因重力而下落
     *
     * 那么怎样玩才能使得最后剩下的不能消掉的格子尽量少
     */
    public static void deldelHappy() {
        int[][] nums = new int[][]{
            {3, 1, 2, 1, 1},
            {1, 1, 1, 1, 3},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {3, 1, 2, 2, 2},
        };
    }

    public static void fun() {
        String s = "AaAAAA";
        int[] low = new int[s.length()];
        int[] up = new int[s.length()];
        int len = s.length();
        char last = s.charAt(len - 1);
        if (Character.isLowerCase(last)) {
            low[len - 1] = 1;
            up[len - 1] = 2;
        } else {
            low[len - 1] = 2;
            up[len - 1] = 1;
        }
        for (int i = len - 2; i>-1; i--) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                low[i] = 1 + low[i + 1];
                up[i] = 2 + Math.min(low[i + 1], up[i + 1]);
            } else {
                up[i] = 1 + up[i + 1];
                low[i] = 2 + Math.min(low[i + 1], up[i + 1]);
            }
        }
        System.out.println(low[0]);
    }

    public static void upperLow() {
        Scanner scanner = new Scanner(System.in);
        //int len = scanner.nextInt();
        //String s = scanner.nextLine();
        //String str = scanner.nextLine();
        int len = 6;
        String str = "AAaAAA";
        char[] chars = str.toCharArray();
        int count = 0;
        //表示小写
        int flag = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c) && flag == 0) {
                if (i < chars.length - 1 && chars[i + 1] == c) {
                    count++;
                    //切换为大写模式
                    flag = 1;
                } else {
                    count++;
                }
            } else if (Character.isLowerCase(c) && flag == 1) {
                if (i < chars.length - 1 && chars[i + 1] == c) {
                    count++;
                    //切换为小写模式
                    flag = 0;
                } else {
                    count++;
                }
            }
        }
        System.out.println(len + count);
    }
}
