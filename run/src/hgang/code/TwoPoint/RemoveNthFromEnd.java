package hgang.code.TwoPoint;

import hgang.code.list.ListNode;

import java.util.List;


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
// 👍 1493 👎 0


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
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        while (cur!=null&&cur.next!=null) {
            if(n>0) {
                cur = cur.next;
                n--;
                continue;
            }
            else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        if (pre!=null&&pre.next!=null)
        pre.next = pre.next.next;
        return dummy.next;
    }
    //优化下代码
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head==null||head.next==null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        while (n>0) {
            cur = cur.next;
            n--;
        }
        while (cur.next!=null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
