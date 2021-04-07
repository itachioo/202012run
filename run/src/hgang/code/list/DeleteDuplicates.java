package hgang.code.list;

//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
// Related Topics 链表
// 👍 439 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class DeleteDuplicates{
    public static void main(String[] args) {
        deleteDuplicatesSolution solution = new deleteDuplicatesSolution();
        ListNode1 node = new ListNode1(1);
        node.next = new ListNode1(1);
        node.next.next = new ListNode1(2);
        node.next.next.next = new ListNode1(3);
        node.next.next.next.next = new ListNode1(3);
        System.out.println(solution.deleteDuplicates1(node));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

//leetcode submit region end(Prohibit modification and deletion)

}

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}
class deleteDuplicatesSolution {
    public ListNode1 deleteDuplicates(ListNode1 head) {
        if(head==null) return head;
        //用了pre、cur两个指针，如果当前节点的值和前一个节点的值不同，则pre的next指向cur，同时pre指针指向cur，cur指向cur.next
        ListNode1 pre = head;
        ListNode1 cur = head.next;
        while (cur!=null) {
            if(cur.val!=pre.val) {
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        pre.next = null;
        return head;
    }

    public ListNode1 deleteDuplicates1(ListNode1 head) {
        if(head==null) return head;
        //换个思路，比较cur和cur的下个节点，用一个指针cur
        ListNode1 cur = head;
        while(cur!=null&&cur.next!=null) {
            if(cur.val==cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

