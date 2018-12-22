package offer;

import java.util.Stack;

/**
 * 关于栈的问题
 * @author 14512 on 2018/12/22.
 */
public class StackQuestion {

    public static void main(String[] argv) {
//        question1();
//        question2();
    }

    /**
     * 一个栈中元素为整型，将该栈从顶到底按从大到小排序，只需申请一个栈，不能额外申请其他数据结构
     * 例：7 5 6 9 8 1  排序后 1 5 6 7 8 9（栈底到栈顶)
     */
    private static void question2() {
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(5);
        stack.push(6);
        stack.push(9);
        stack.push(8);
        stack.push(1);
        sortStack(stack);
    }

    private static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        //存放比较的最大值
        Stack<Integer> helpStack = new Stack<>();
        int cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (helpStack.isEmpty() || cur <= helpStack.peek()) {
                helpStack.push(cur);
            } else {
                stack.push(helpStack.pop());
                stack.push(cur);
            }
        }
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
        System.out.println(stack.toString());
    }

    /**
     * 给定一个栈，将栈中元素逆序，不许申请其他的数据结构
     * 例：栈底到栈顶 1 2 3， 变为 3 2 1
     */
    private static void question1() {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        reverseStack(stack);
        System.out.println(stack.toString());
    }

    private static void reverseStack(Stack<String> stack) {
        if (stack.isEmpty()) {
            return;
        }
        String s = getStackBottom(stack);
        reverseStack(stack);
        stack.push(s);
    }

    private static String getStackBottom(Stack<String> stack) {
        String s = stack.pop();
        if (stack.isEmpty()) {
            return s;
        } else {
            String last = getStackBottom(stack);
            stack.push(s);
            return last;
        }
    }
}
