package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.lang.StringBuilder;

/**
 * @author PHS1024
 * @date 2019/8/22 20:14
 */
public class NConvert2MQuestion {
    private static Map<Character, Integer> sMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(n2m("24", 7, 2));

    }

    public static String n2m(String num, int n, int m) {
        if (num == null || num.isEmpty() || n < 2 || n > 16 || m < 2 || m > 16) {
            return null;
        }
        long decimalism = n2ten(num, n);
        System.out.println(decimalism);
        return ten2m(decimalism, m);
    }

    private static String ten2m(long decimalism, int m) {
        Stack<Long> stack = new Stack<>();
        while (true) {
            stack.push(decimalism % m);
            decimalism /= m;
            if (decimalism < m) {
                stack.push(decimalism);
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static long n2ten(String num, int n) {
        if (n == 10) {
            return Long.parseLong(num) - Long.parseLong("0");
        }
        long res = 0;
        int count = 0;
        char[] chars = num.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            int tmp = (int) chars[i] - (int) '0';
            res += tmp * Math.pow(n, count++);
        }
        return res;
    }
}
