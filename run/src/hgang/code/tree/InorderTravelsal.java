package hgang.code.tree;


//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[2,1]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树
// 👍 1053 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import hgang.code.list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class InorderTravelsal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root==null) return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()||root!=null) {
            if (root!=null) {    // 不断往左子树方向走，并压入栈中
                stack.push(root);
                root = root.left;

            }
            //当前节点为空的话，说明左边到头了，从栈中弹出结点
            //转向右边节点继续上面的过程
            else {
                TreeNode node = stack.pop();
                res.add(node.val);
                root = node.right;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
