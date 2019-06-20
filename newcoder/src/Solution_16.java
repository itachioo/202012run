public class Solution_16 {
    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像
     */
    public void Mirror(TreeNode root) {
        if(root==null) return;
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = r;
        root.right = l;
        Mirror(l);
        Mirror(r);
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
