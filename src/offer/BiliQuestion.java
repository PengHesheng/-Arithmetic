package offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author PHS1024
 * @date 2019/9/10 19:41
 */
public class BiliQuestion {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String str = in.nextLine();
        //if (str == null || str.isEmpty()) {
        //    return;
        //}
        //String str = "AAABBBCDDAAAAAACD";
        //String res = longStr(str);
        //System.out.println(res);
        question2("bilibili",
                "bbiliili1");
    }

    public static String longStr(String str) {
        int index = 0;
        int start = 0;
        int len = 0;
        int curLen = 0;
        char last;
        while (index < str.length()) {
            curLen = 0;
            last = str.charAt(index);
            while (index < str.length() && last == str.charAt(index)) {
                curLen++;
                index++;
            }
            if (curLen != 0 && len <= curLen) {
                len = curLen;
                start = index - curLen;
            }
            index++;
        }
        return str.substring(start, start + len);
    }

    public static void question2(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        boolean isSame = true;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < chars1.length; i++) {
            if (map1.containsKey(chars1[i])) {
                map1.put(chars1[i], map1.get(chars1[i])+1);
            } else {
                map1.put(chars1[i], 0);
            }
            if (map2.containsKey(chars2[i])) {
                map2.put(chars2[i], map2.get(chars2[i])+1);
            } else {
                map2.put(chars2[i], 0);
            }
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.get(entry.getKey()).equals(entry.getValue())) {
                isSame = false;
                break;
            }
        }
        System.out.println(isSame);
    }
}
