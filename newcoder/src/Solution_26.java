public class Solution_26 {
    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right)&&Math.abs(depthTree(root.left)-depthTree(root.right))<=1;

    }


    public int depthTree(TreeNode root) {
        if(root==null) return 0;
        return 1 + Math.max(depthTree(root.left), depthTree(root.right));
    }
}
