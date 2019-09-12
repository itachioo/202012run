import java.util.HashSet;

public class Solution_36 {
    /**
     * 链表中环的入口节点
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        /**
         *  使用Hashset实现
         */
        HashSet<ListNode> set = new HashSet<>();
        while(pHead!=null) {
            if(!set.contains(pHead)) {
                set.add(pHead);
                pHead = pHead.next;
            }
            else return pHead;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        /**
         * 快慢指针实现，fast每次2步，slow每次一步，如果有环，肯定会在slow进入环的第一圈相遇
         */
        ListNode fast = pHead;
        ListNode slow = pHead;
        if(pHead==null) return null;
        while(fast.next!=null&&fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }
        if(fast.next==null||fast.next.next==null) return null;
        slow = pHead;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
