package hgang.code;

//Merge two sorted linked lists and return it as a new sorted list. The new list
// should be made by splicing together the nodes of the first two lists.
//
//
// Example 1:
//
//
//Input: l1 = [1,2,4], l2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//
//
// Example 2:
//
//
//Input: l1 = [], l2 = []
//Output: []
//
//
// Example 3:
//
//
//Input: l1 = [], l2 = [0]
//Output: [0]
//
//
//
// Constraints:
//
//
// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both l1 and l2 are sorted in non-decreasing order.
//
// Related Topics Linked List
// 👍 5496 👎 682

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists {
    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next  = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode node = solution.mergeTwoLists(l1,l2);
    }
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

}
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1!=null&&l2!=null) {
            dummy.next = l1.val<=l2.val? l1:l2;
            //临时节点，记录l1
            ListNode temp = l1;
            l1 = l1.val<=l2.val? l1.next:l1;
            //此处常犯错误，l2 = l1.val<=l2.val?l2:l2.net，如果不设置temp，这里l1已经更新过了，再用会出错。
            l2 = temp.val<=l2.val? l2:l2.next;
            dummy = dummy.next;
        }
        if(l1!=null) dummy.next = l1;
        if(l2!=null) dummy.next = l2;
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

