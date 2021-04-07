package hgang.code.list;

//编写一个函数，检查输入的链表是否是回文的。
//
//
//
// 示例 1：
//
// 输入： 1->2
//输出： false
//
//
// 示例 2：
//
// 输入： 1->2->2->1
//输出： true
//
//
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表
// 👍 54 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class isPalindrome {
    public static void main(String[] args) {
        isPalindromeSolution solution = new isPalindromeSolution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        System.out.println(solution.isPalindrome1(head));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //leetcode submit region end(Prohibit modification and deletion)
}

class isPalindromeSolution {
    /* 可以先把链表值放在数组里，然后双指针一个从头一个从尾遍历，直至指针相遇，回文连表，头尾指针对应的值相等
     * 使用了额外的数组空间
     */
    public boolean isPalindrome(ListNode head) {
        return true;
    }

    //可以反转后一半链表，然后对比两段链表
    public boolean isPalindrome1(ListNode head) {
        ListNode node = head;
        ListNode halfHead = new middleNodeSolution().middleNode(node);
        ListNode halfReverseHead = reverse(halfHead);
        ListNode l = head;
        ListNode r = halfReverseHead;
        //判断两段链表是否相同
        while (r!=null) {    // 以被反转的链表为判断条件；
            if (l.val!=r.val) {
                reverse(halfReverseHead);
                return false;
            }
            else {
                l = l.next;
                r = r.next;
            }
        }
        reverse(halfReverseHead);
        return true;
    }
    // 递归反转链表
    private ListNode reverse(ListNode node) {
        if (node==null||node.next==null) return node;
        ListNode p = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
