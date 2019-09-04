package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PHS1024
 * @date 2019/8/30 19:54
 */
public class AliQuestion {

    public static void main(String[] args) {
        minDi("abcdefjhijklmnopqrstuvwxyz", "abc123defjhklmnopqr456stuvwz");
    }

    /**
     * 字符串最小补丁
     *
     * 在客户端应用中，多端之间数据同步是常见需求。如果需要同步的数据体比较大，我们一般通过“补丁”的方式减少传输数据量。
     * 现有一种补丁格式，描述了两个字符串之间的差异，补丁结构如下所示：
     * {
     *     removeList : [
     *                                 {index:int, length:int},
     *                                 ...
     *                         ],
     *
     *     addList : [
     *                                 {index:int, data:string},
     *                                 ...
     *                         ]
     * }
     * removeList描述了要从原字符串删除的子串的位置和长度，其中每个元素的index属性表示要删除的子串在原字符串中的起始位置，length表示要删除的子串长度。
     * addList描述了新插入的子串的位置和内容，其中每个元素的index属性表示新插入的子串在新字符串中的起始位置，data表示子串的内容。
     * 如原字符串为： abcdefjhijklmnopqrstuvwxyz
     * 新字符串为： abc123defjhklmnopqr456stuvwz
     * 则生成的补丁为：
     * {
     *     removeList : [
     *                                 {index:8, length:2},
     *                                 {index:23, length:2}
     *                         ],
     *
     *     addList : [
     *                                 {index:3, data:"123"}
     *                                 {index:19, data:"456"}
     *                         ]
     * }
     * 已知removeList中每个元素占用空间为2字节。addList中每个元素占用空间为2字节+内容长度。如“{index:3, data:"123"}”占用空间为2+3=5字节。整个补丁占用空间为两个列表中所有元素占用空间的总和。所以例子中补丁占用为2+2+(2+3)+(2+3)=14字节。
     * @param oldString
     * @param newString
     * @return
     */
    private static int minDi(String oldString, String newString) {
        if ((oldString == null && newString == null) || (oldString.isEmpty() && newString.isEmpty())) {
            return 0;
        }
        if (oldString.isEmpty()) {
            return newString.length() + 2;
        }
        if (newString.isEmpty()) {
            return 2;
        }
        char[] olds = oldString.toCharArray();
        char[] news = newString.toCharArray();
        int i = 0;
        int j = 0;
        Map<Integer, String> addMap = new HashMap<>();
        Map<Integer, String> removeMap = new HashMap<>();
        while (i < olds.length && j < news.length) {
            if (olds[i] != news[j]) {
                if (isAdd(olds, news, i, j)) {
                    StringBuilder sb = new StringBuilder();
                    while (olds[i] != news[j]) {
                        sb.append(news[j]);
                        j++;
                    }
                    addMap.put(i, sb.toString());
                } else if (isAdd(news, olds, j, i)){
                    StringBuilder sb = new StringBuilder();
                    while (olds[i] != news[j]) {
                        sb.append(olds[i]);
                        i++;
                    }
                    removeMap.put(j, sb.toString());
                } else {
                    //new add
                    int index = j;
                    StringBuilder sb = new StringBuilder();
                    while (j < news.length) {
                        sb.append(news[j]);
                        j++;
                    }
                    addMap.put(index, sb.toString());
                    //old remove
                    index = i;
                    sb = new StringBuilder();
                    while (i < olds.length) {
                        sb.append(olds[i]);
                        i++;
                    }
                    removeMap.put(index, sb.toString());
                }
            }
            i++;
            j++;
        }
        int res = removeMap.size() * 2 + addMap.size() * 2;
        for (String str : addMap.values()) {
            res += str.length();
        }
        return res;
    }

    private static boolean isAdd(char[] olds, char[] news, int i, int j) {
        while (j < news.length) {
            if (olds[i] == news[j]) {
                return true;
            }
            j++;
        }
        return false;
    }
}
