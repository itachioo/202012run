package hgang.code.list;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1306 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import hgang.code.list.ListNode;

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
public class removeNthFromEnd {
    public static ListNode removeNthFromEndSolution(ListNode head, int n) {
        if(head==null) return head;
        if(head.next==null) return null;
        ListNode pre = new ListNode(-1);
        ListNode start = pre, end = pre;
        while (n>0) {
            start = start.next;
            n--;
        }
        while (start.next!=null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return head;
    }
    public static void main(String[]args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
        removeNthFromEndSolution(head,1);
        System.out.println(head);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
