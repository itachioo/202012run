package hgang.code.list;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 链表
// 👍 115 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class reversePrint {
    public static void main(String[] args) {
        isPalindromeSolution solution = new isPalindromeSolution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(new reversePrintSolution().reversePrint(head));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //leetcode submit region end(Prohibit modification and deletion)
}


class reversePrintSolution {
    //递归
    List<Integer> res = new ArrayList<>();
    public List<Integer> solution(ListNode head) {
        if (head == null) return res;
        solution(head.next);
        res.add(head.val);
        return res;
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> res = solution(head);
        int[] arr =new int[res.size()];
        for (int i=0;i<res.size();i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
