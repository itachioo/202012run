package hgang.code.sep.list2;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶：
//
//
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105
//
// Related Topics 链表 双指针 分治 排序 归并排序
// 👍 1227 👎 0


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
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //快慢指针先找到中点，然后归并排序
        ListNode slow = head;
        ListNode fast = head;
        // 这个条件错了  fast != null && fast.next != null，应该是下面的
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode one = sortList(head);
        ListNode two = sortList(next);
        return mergeList(one, two);

    }
    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1!=null&&l2!=null) {
            if(l1.val> l2.val) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;

            }else {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
        }
        if(l1!=null) cur.next = l1;
        if(l2!=null) cur.next = l2;
        return dummy.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
