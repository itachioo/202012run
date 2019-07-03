public class Solution_25 {
    /**
     * 输入一棵二叉树，求该树的深度。
     * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     */
    int maxDepth = 0;
    int res = 0;
    public int TreeDepth(TreeNode root) {
        if(root==null) return maxDepth;
        maxDepth = maxDepth+1;
        if(root.left==null&&root.right==null) res = Math.max(res, maxDepth);
        TreeDepth(root.left);
        TreeDepth(root.right);
        maxDepth--;
        return res;
    }
}
