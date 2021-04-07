package hgang.code.list;

//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
// 示例1:
//
//
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
//
//
// 示例2:
//
//
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
//
//
// 提示：
//
//
// 链表长度在[0, 20000]范围内。
// 链表元素在[0, 20000]范围内。
//
//
// 进阶：
//
// 如果不得使用临时缓冲区，该怎么解决？
// Related Topics 链表
// 👍 92 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class removeDuplicateNodes{
    public static void main(String[] args) {
        removeDuplicateNodesSolution solution = new removeDuplicateNodesSolution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next  = new ListNode(1);
        solution.removeDuplicateNodes1(head);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

//leetcode submit region end(Prohibit modification and deletion)

}
class removeDuplicateNodesSolution {
    //使用了set去重
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode node = head;
        ListNode pre = head;
        while (node!=null) {
            if (set.contains(node.val)) {
                ListNode temp = node.next;
                pre.next = temp;
                node = temp;
            }else {
                set.add(node.val);
                pre = node;
                node = node.next;
            }
        }
        return head;
    }
    //不使用额外空间,双重循环，外层循环遍历每个节点，内存遍历外层节点之后与其重复的节点，删除。
    public ListNode removeDuplicateNodes1(ListNode head) {
        ListNode node = head;
        while (node!=null) {
            ListNode cur = node.next;
            ListNode pre = node;
            while (cur!=null) {
                if (cur.val==node.val) {
                    pre.next = cur.next;
                    cur = cur.next;
                }
                else {
                    pre = cur;
                    cur = cur.next;
                }
            }
            node = node.next;

        }
        return head;
    }
    //优化下，其实以上两种方法都可以不用两个指针
    public ListNode removeDuplicateNodes2(ListNode head) {
        ListNode node = head;
        while(node!=null) {
            ListNode temp = node;
            while (temp.next!=null) {
                //直接用 当前节点的next 的val和 当前节点 的val比较，不需要再记pre节点。
                if(temp.next.val==node.val) {
                    temp.next = temp.next.next;
                }else {
                    temp = temp.next;
                }
            }
            node = node.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
