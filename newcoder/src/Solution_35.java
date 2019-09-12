import java.util.List;

public class Solution_35 {
    /**
     * 删除链表中重复的节点，例如输入：1->1->1->2->3
     * 输出：2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=null) {
            while(cur.next!=null && cur.next.val==cur.val) {
                cur = cur.next;
            }
            if(pre.next==cur) {
                pre = cur;
            }
            else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
