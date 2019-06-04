import java.util.Stack;

public class Solution_7 {
    /**
     * 题目：用两个栈实现一个队列
     * 思路：本题较为简单，push时直接在stack1；
     *       pop时先把stack1中的push到stack2中，pop完后，再把stack2中的移入stack1
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int res = Integer.MIN_VALUE;
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        if(!stack2.empty()) {
            res = stack2.pop();
        }
        while(!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return res;

    }
}
