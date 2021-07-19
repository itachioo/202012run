package hgang.code.sep.list2;
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
//
//
// 示例 2：
//
//
//输入：head = [5], left = 1, right = 1
//输出：[5]
//
//
//
//
// 提示：
//
//
// 链表中节点数目为 n
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
//
//
//
//
// 进阶： 你可以使用一趟扫描完成反转吗？
// Related Topics 链表
// 👍 933 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import hgang.code.list.ListNode;

import java.util.List;

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

public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next  = new ListNode(4);
//        head.next.next.next.next  = new ListNode(5);
        ReverseBetweenSolution solution = new ReverseBetweenSolution();
        ListNode p = solution.reverseBetween1(head,1,1);
        System.out.println(p);
    }
}

class ReverseBetweenSolution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //讨论单节点的情况
        if(head==null||head.next==null) return head;

        ListNode leftFlag= head;
        int val = right-left;
        int flag = 1;
        //没有cover住从头节点开始的情况
        while(left-1>flag) {
            leftFlag = leftFlag.next;
            flag++;
        }
        ListNode newHead = null;
        newHead = leftFlag.next;
        ListNode rightFlag = head;
        while(right>0) {
            rightFlag = rightFlag.next;
            right--;
        }
        ListNode node = reverse3(newHead);
        leftFlag.next = node;
        while(node!=null&&node.next!=null) {
            node = node.next;
        }
        node.next = rightFlag;
        return head;
    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if (head==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //找到left节点的前一个节点，从dummy走left-1步
        ListNode leftPrev = dummy;
        for(int i=0;i<left-1;i++) {
            leftPrev = leftPrev.next;
        }
        ListNode leftNode = leftPrev.next;
        ListNode rightNode = dummy;
        for(int i=0;i<right;i++) {
            rightNode = rightNode.next;
        }
        ListNode rightNext = rightNode.next;
        //截断链表，截出要反转的链表
        leftPrev.next = null;
        rightNode.next = null;
        //反转链表
        reverse3(leftNode);
        //连接链表
        leftPrev.next = rightNode;
        leftNode.next = rightNext;
        return dummy.next;
    }
    public ListNode reverse3(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
