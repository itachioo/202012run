package hgang.code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索 二叉树
// 👍 960 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }
 }

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size>0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                size--;
            }
            res.add(temp);
        }
        return res;
    }
    public List<List<Integer>> levelOrder1(TreeNode root) {
        //递归不太好理解，先略过
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
