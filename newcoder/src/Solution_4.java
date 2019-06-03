import java.util.ArrayList;
import java.util.Stack;

public class Solution_4 {
    /**
     * 题目：输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.empty()) {
            int val = stack.pop();
            res.add(val);
        }
        return res;
    }
    ArrayList<Integer> res1 = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        /**
         * 递归版本
         */
       if(listNode == null) return res1;
       if(listNode.next==null) {
           res1.add(listNode.val);
           return res1;
       }
       else {
           printListFromTailToHead1(listNode.next);
           res1.add(listNode.val);
           return res1;
       }

    }
}


class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}