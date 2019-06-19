public class Solution_13 {
    /**
     * 题目：输入一个链表，反转链表后，输出新链表的表头。
     */
    public ListNode ReverseList(ListNode head) {
        /**
         * 思路1：利用数据结构栈，使用了额外的空间
         * 思路2：原地反转链表
         */
        if(head==null) return null;
        ListNode dummy = null;
        ListNode sec = head.next ;
        while(sec!=null) {
            head.next = dummy;
            dummy = head;
            head = sec;
            sec = sec.next;
        }
        head.next = dummy;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
