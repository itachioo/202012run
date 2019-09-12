public class Solution_37 {
    /**
     * 反转链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur!=null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
