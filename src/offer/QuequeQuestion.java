package offer;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 14512 on 2018/12/22.
 */
public class QuequeQuestion {

    public static void main(String[] argv) {
        question1();
    }

    /**
     * 一个数组arr，一个滑动窗口为w，从左滑到右，输出每一次滑动窗口的最大值
     * 例数组4 3 5 4 3 3 6 7 w=3
     * 输出5 5 5 4 6 7
     */
    private static void question1() {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (deque.isEmpty() || arr[deque.getLast()] > arr[i]) {
                deque.addLast(i);
            } else {
                while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i]) {
                    deque.pollLast();
                }
                deque.addLast(i);
            }
            while (i - deque.getFirst() >= w) {
                deque.pollFirst();
            }
            if (i < w-1) {
                continue;
            }
            queue.add(arr[deque.getFirst()]);
        }
        System.out.println(queue.toString());
    }
}
