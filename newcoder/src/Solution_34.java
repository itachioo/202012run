public class Solution_34 {
    /**
     * 从已经排序的链表中删除重复的元素
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        int flag = head.val;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null) {
            if (cur.val==flag){
                pre.next = cur.next;
                cur = cur.next;
            }
            else{
                flag = cur.val;
                pre = cur;
                cur = cur.next;
            }

        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        /**
         * 简化代码
         */
        ListNode cur = head;
        while(cur!=null&&cur.next!=null) {
            if(cur.next.val==cur.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }
}
