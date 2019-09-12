public class Solution_39 {
    /**
     * 翻转链表指定位置
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
        ListNode cur = head;
        if(head==null) return head;
        int index = 1;
        ListNode mNode = null;
        while (cur!=null&&index<=n) {
            if(m<=index&&index<=n) {
                if(index==m) {
                    mNode = pre;
                    pre = cur;
                    cur = cur.next;
                    index++;
                }
                else {
                    ListNode temp = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = temp;
                    index++;
                }

            }
            else {
                pre = cur;
                cur = cur.next;
                index++;
            }
        }
        if(mNode!=null) {
            ListNode temp1 = mNode.next;
            mNode.next = pre;
            temp1.next = cur;
        }

        return head;
    }
}
