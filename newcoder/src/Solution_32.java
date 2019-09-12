import java.util.Stack;

public class Solution_32 {
    /**
     * 题目： 给出一个链表，每k个节点一组进行翻转，并返回翻转后的链表。
     * k是一个整数，它的值小于或等于链表的长度，如果节点总数不是k的整数倍，那么将最后
     * 剩余节点保持原有顺序
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        /**
         * 思路：利用栈来翻转节点
         */
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(-1);
        ListNode next = dummy;
        dummy.next = head;
        ListNode cur = head;
        if(head==null) return head;
        while(cur!=null) {
            for(int i=0;i<k&&cur!=null;i++) {
                stack.push(cur);
                cur = cur.next;
            }
            if(stack.size()<k) return dummy.next;
            while(!stack.isEmpty()) {
                next.next = stack.pop();
                next = next.next;
            }
            next.next = cur;
        }
        return dummy.next;
    }


}
