import org.junit.jupiter.api.Test;

public class Solution_14 {
    /**
     * 题目：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */
    public ListNode Merge(ListNode l1,ListNode l2) {
        /**
         * 思路1：类似于插入排序，list2在list1中找到合适的位置插进去
         */
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode pre = new ListNode(Integer.MAX_VALUE);
        ListNode cur = l1;
        // ListNode next = cur.next;
        ListNode head = l2.val<=l1.val ? l2 : l1;
        while(l2!=null) {
            ListNode temp = l2.next;
            while(cur!=null) {
                if(l2.val>cur.val) {
                    pre = cur;
                    cur = cur.next;
                    // if(cur==null) {
                    //     pre.next = l2;
                    //     l2.next = null;
                    //     cur = l2;
                    //     next = cur.next;
                    //     l2 = temp;
                    //     break;
                    // }
                    // else{
                    //     next = cur.next;
                    // }

                }
                else{
                        pre.next = l2;
                        l2.next = cur;
                        pre = l2;
                        l2 = temp;
                        break;
                }
            }
            if(cur==null) {
                pre.next = l2;
                break;
            }
        }
        return head;
    }

    @Test
    public void testMerge() {
        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        l1.next = l3;
        l3.next = l5;

        ListNode l2 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        ListNode l6 = new ListNode(5);
        ListNode l8 = new ListNode(7);
        ListNode l9 = new ListNode(9);
        l2.next = l4;
        l4.next = l6;
        l6.next = l8;
        l8.next = l9;
        System.out.println(Merge(l1,l2));
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
