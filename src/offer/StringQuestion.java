package offer;

import java.util.Arrays;

/**
 * @author 14512 on 2018/10/29.
 */
public class StringQuestion {

    public static void main(String[] args) {
        System.out.println(question1("1234", "2341"));
        question2("pig loves dog");
        question3("ABCDE", 2);
        question4("abcde", "ba");
    }

    private static void question4(String str1, String str2) {
        StringBuilder sb1 = new StringBuilder(str1 + str2);
        StringBuilder sb2 = new StringBuilder(str2 + str1);
        //if sb1 < sb2, return str1 < str2
    }

    /**
     * 给定一个字符串str，和一个整数i，i表示str中的位置，将str[0..i]移到右侧，str[i+1..N-1]移到左侧
     * 例str="ABCDE",i=2,调整为"DEABC"
     * 时间复杂度O(N)，额外空间复杂度O(1)
     * @param str
     * @param i
     */
    private static void question3(String str, int i) {
        char[] chars = str.toCharArray();
        int n = str.length() - 1;
        int k;
        //从中间向两头进行逆序
        for (int j = (i - 1) >> 1; j >= 0 ; j--) {
            k = i - j;
            char c = chars[j];
            chars[j] = chars[k];
            chars[k] = c;
        }
        for (int j = ((n - i) >> 1) + i; j > i; j--) {
            k = n - j + i + 1;
            char c = chars[j];
            chars[j] = chars[k];
            chars[k] = c;
        }
        for (int j = (n - 1) >> 1; j >= 0; j--) {
            k = n - j;
            char c = chars[j];
            chars[j] = chars[k];
            chars[k] = c;
        }
        System.out.println(Arrays.toString(chars));
    }

    /**
     * 给定一个字符串str，在单词间逆序调整
     * 例"pig loves dog"逆序成"dog loves pig"
     * @param str
     */
    private static void question2(String str) {
        //利用StringBuilder
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        String reverseStr = stringBuilder.toString();
        String[] strings = reverseStr.split(" ");
        stringBuilder.setLength(0);
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.setLength(0);
            sb.append(s);
            sb.reverse();
            stringBuilder.append(sb).append(" ");
        }
        String result = stringBuilder.substring(0, stringBuilder.length() - 1);
        System.out.println(result);
        //不使用StringBuilder，自己实现reverse
    }

    /**
     * 如果一个字符串str，把字符串前面任意的部分挪到后面去形成的字符串叫str的旋转词
     * 例str="1234"，旋转词有"1234","2341","3412","4123"
     * 判断是否为旋转词
     * @param str1
     * @param str2
     */
    private static boolean question1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        //组成一个大字符串，包含了（穷举）所有的旋转词，KMP算法
        String str = str1 + str1;
        for (int i = 0; i < str1.length(); i++) {
            if (str.substring(i, str1.length() + i).contentEquals(str2)) {
                return true;
            }
        }
        return false;
    }
}
