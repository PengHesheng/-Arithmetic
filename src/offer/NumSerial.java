package offer;

import java.util.HashMap;

/**
 * 数字以序列01234567891011121314...，找出第1001位对应的数字
 * @author PHS1024
 * @date 2019/8/18 20:45
 */
public class NumSerial {

    public static void main(String[] args) {
        System.out.println(digitAtIndex(1001));
    }

    public static int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        //位数
        int digit = 1;
        while (true) {
            int nums = countOfNum(digit);
            if (index < nums * digit) {
                return digitAtIndex(index, digit);
            }
            index -= nums * digit;
            digit++;
        }
    }

    private static int digitAtIndex(int index, int digit) {
        int num = begin(digit) + index / digit;
        int resIndex = index % digit;
        char[] res = String.valueOf(num).toCharArray();
        return res[resIndex] - 48;
    }

    private static int begin(int digit) {
        return digit == 1 ? 0 : (int) Math.pow(10, digit - 1);
    }


    private static int countOfNum(int digit) {
        if (digit == 1) {
            return 10;
        }
        return (int) (9 * Math.pow(10, digit - 1));
    }
}
