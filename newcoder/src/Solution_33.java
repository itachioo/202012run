public class Solution_33 {
    /**
     * 题目： 给定一个链表，删除倒数第n个节点，并且返回链表的头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 错误做法，只有一个节点的时候，无法正确工作，例如：[1] n=1
         */
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len ++;
            cur = cur.next;
        }
        if(n>len) return null;
        ListNode pre = head;
        cur = head;           // 存在漏洞，pre和cur是同一个节点的时候，是无法删除cur节点的。
        for (int i=1;i<len-n+1;i++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;   //删除的是cur节点
        return head;

    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        /**
         * 为了避免出现pre和cur是同一个节点，设置一个dummy节点，要删除的节点为cur.next
         */
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len ++;
            cur = cur.next;
        }
        if(n>len) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        cur = dummy;
        for (int i=0;i<len-n;i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

     public ListNode removeNthFromEnd2(ListNode head, int n) {
        /**
         * 使用两个指针
         */
        ListNode dummmy = new ListNode(-1);
        dummmy.next = head;
        ListNode fast = dummmy;
        ListNode slow = dummmy;
        for (int i=0;i<n+1;i++) {
            fast = fast.next;
        }
        while(fast!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummmy.next;
    }

}
