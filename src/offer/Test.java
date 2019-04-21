package offer;

/**
 * @author 14512 on 2018/11/27.
 */
public class Test {
    public static void main(String[] argc) {

//        int[][]ba = new int[3][6];
//        System.out.println(ba.length +"  "+ ba[0].length);
//        System.out.println(question3(new int[]{2, 3, 1, 0, 2, 5, 3}));

//        System.out.println(NumberOf1(-3));
//        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(ReverseList(node1).val);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int value, ListNode next) {
            this.val = value;
            this.next = next;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node1 = head;
        ListNode node2 = node1.next;
        ListNode node3;

        node1.next = null;
        while(node2 != null) {
            node3 = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = node3;
        }

        return node1;
    }

    public static int NumberOf1(int n) {
        int count = 0;
        int target = n;
        int flag = 1;
        while(target != 0) {
            count++;
            target = (target - 1) & target;
        }
        return count;
    }

    public static int Fibonacci(int n) {
        int f0 = 0;
        int f1 = 1;

        if(n <= 0) {
            return f0;
        }

        if(n == 1) {
            return f1;
        }

        while(n > 1) {
            f1 += f0;
            f0 = f1;
            n--;
        }
        return f1;
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
