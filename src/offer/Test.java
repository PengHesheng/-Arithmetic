package offer;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 14512 on 2018/11/27.
 */
public class Test {
    public static void main(String[] argc) {
        System.out.println(question3(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    /**
     * 找出数组中重复的数字
     * 长度为n的数组，数字在0~n-1
     * 输入长度为7的数组[2,3,1,0,2,5,3]，输出重复的2或者3
     */
    private static boolean question3(int[] a) {
        //1、排序，遍历数组
        //2、哈希表
        //3、利用数组的特性

        //边界检查
        if (a == null || a.length <= 0) {
            return false;
        }

        for (int num : a) {
            if (num < 0 || num > a.length - 1) {
                return false;
            }
        }

        //遍历数组，将对应的数组元素交换到对应的下标去，如果出现了待交换的元素与已经存在的下标相同，则有重复
        for (int i = 0; i < a.length; i++) {
            //元素在对应的下标时，则跳过
            while (a[i] != i) {
                if (a[i] == a[a[i]]) {
                    return true;
                }

                //交换位置
                int temp = a[i];
                a[i] = a[temp];
                a[temp] = temp;
            }
        }

        return false;
    }

    /**
     * 在question3的基础上，不能改变数组
     * @param a int[]
     * @return
     */
    private static boolean question3_1(int[] a) {
        //1、可以考虑额外的数组空间

        if (a == null || a.length <= 0) {
            return false;
        }

        for (int num : a) {
            if (num < 0 || num > a.length - 1) {
                return false;
            }
        }

        int start = 1, end = a.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(a, start, middle);
            if (end == start) {
                if (count > 1) {
                    return true;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return false;
    }

    private static int countRange(int[] a, int start, int end) {
        if (a == null) {
            return 0;
        }

        int count = 0;
        for (int num : a) {
            if (num >= start && num <= end) {
                count++;
            }
        }
        return count;
    }

}
