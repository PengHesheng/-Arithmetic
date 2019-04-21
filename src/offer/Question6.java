package offer;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * @author PHS
 * @create 2019-04-01 10:12
 **/
public class Question6 {
    class Node {
        int key;
        Node next;
    }

    private static void reverse(Node head) {
        Stack<Node> nodeStack = new Stack<>();

        Node node = head;
        while (node != null) {
            nodeStack.push(node);
            node = node.next;
        }

        while (!nodeStack.empty()) {
            node = nodeStack.pop();
            System.out.println(node.key);
            nodeStack.pop();
        }
    }

}
