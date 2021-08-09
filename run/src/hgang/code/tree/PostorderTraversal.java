package hgang.code.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


//给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树
// 👍 641 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        // 左右中 可以由 中右左 反转得到，中右左 就是先序遍历 微调了顺序
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root==null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            //调整先序遍历的顺序
            if (node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
