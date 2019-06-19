public class Solution_12 {
    /**
     * 题目：输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        /**
         * 思路1：使用连个指针，fast、slow，fast先开始移动，移动到第k个节点时，
         */
        if(head ==null||k<=0) return null;
        ListNode fast = head;
        ListNode slow = head;
        int cnt = 1;
        for(int i=1;i<k;i++) {
            fast = fast.next;
            if(fast==null) return null;   //k > n时，返回null
        }
        while(fast != null&&fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
