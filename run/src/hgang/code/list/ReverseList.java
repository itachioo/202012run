package hgang.code.list;

//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
// 👍 1582 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


public class ReverseList{
    public static void main(String[] args) {
        ListNode head = null;
        ReverseListSolution solution = new ReverseListSolution();
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next  = new ListNode(4);
        //ListNode p = solution.reverseList(head);
        //System.out.println( solution.reverseList(p));
        solution.reverse2(head);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

//leetcode submit region end(Prohibit modification and deletion)

}

class ReverseListSolution {
    //递归
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        return reverse(pre,cur,next);
    }

    private ListNode reverse(ListNode pre, ListNode cur, ListNode next) {
        if(cur==null) return pre;
        next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
        ListNode p = reverse(pre, cur, next);
        return p;
    }

    //递归优化
    public ListNode reverse1(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode p = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    //迭代
    public ListNode reverse2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
