package hgang.code.list;

//编写一个程序，找到两个单链表相交的起始节点。
//
// 如下面的两个链表：
//
//
//
// 在节点 c1 开始相交。
//
//
//
// 示例 1：
//
//
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//
//
//
// 示例 2：
//
//
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//
//
//
// 示例 3：
//
//
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
//
//
//
//
// 注意：
//
//
// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
//
// Related Topics 链表
// 👍 1081 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class getIntersectionNode {
    public static void main(String[] args) {
        isPalindromeSolution solution = new isPalindromeSolution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        System.out.println(new getIntersectionNodeSolution().getListNodeSize(head));
    }

}

class getIntersectionNodeSolution{
    //思路：先遍历两遍找到A B的长度，然后从到链表尾部长度相等的位置开始两两比较
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListNodeSize(headA);
        int lenB = getListNodeSize(headB);
        if(lenA>lenB) {
            int num = lenA-lenB;
            while (num>0) {
                headA = headA.next;
                num--;
            }
        }else {
            int num = lenB-lenA;
            while (num>0) {
                headB = headB.next;
                num--;
            }
        }
        return compare(headA,headB);
    }

    public ListNode compare(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        while (headA!=null) {
            if(headA.val!= headB.val) return null;
            headA = headA.next;
            headB = headB.next;
        }
        return temp;
    }
    public int getListNodeSize(ListNode head) {
        int i=0;
        ListNode node = head;
        while(node!=null) {
            i++;
            node = node.next;
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

