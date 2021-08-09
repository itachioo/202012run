package hgang.code.tree;


//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 1485 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null) return true;
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            //镜像位置的两个节点
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode==null&&rightNode==null) continue;
            if (leftNode==null||rightNode==null||leftNode.val!=rightNode.val) return false;
            //(leftNode!=null||rightNode!=null||(leftNode.val!=rightNode.val))
            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }
        return true;
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root==null) return true;
        return process(root.left,root.right);
    }

    public boolean process(TreeNode left, TreeNode right) {
        if (left!=null&&right==null) return false;
        if (right!=null&&left==null) return false;
        if (left==null&&right==null) return true;
        if (left.val!=right.val) return false;
        return process(left.left,right.right)&&process(left.right,right.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
