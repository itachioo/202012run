import org.junit.jupiter.api.Test;

public class Solution_14 {
    /**
     * 题目：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        /**
         * 思路1：类似于插入排序，list2在list1中找到合适的位置插进去
         */
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode pre = new ListNode(Integer.MAX_VALUE);
        ListNode cur = list1;
        ListNode next = cur.next;
        ListNode head = list2.val<=list1.val ? list2 : list1;
        while(list2!=null) {
            ListNode temp = list2.next;
            while(cur!=null) {
                if(list2.val>cur.val) {
                    pre = cur;
                    cur = next;
                    if(cur==null) {
                        pre.next = list2;
                        list2.next = null;
                        cur= list2;
                        next = cur.next;
                        list2 = temp;
                    }
                    else{
                        next = cur.next;
                    }

                }
                else{
//                    if(pre==null) {
//                        list2.next = cur;
//                        pre = cur;
//                        cur = next;
//                        next = next.next;
//                        list2 = temp;
//                        break;
//                    }
//                    else{
                        pre.next = list2;
                        list2.next = cur;
                        pre = list2;
                        list2 = temp;
                        break;
//                    }
                }
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
