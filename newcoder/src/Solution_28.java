public class Solution_28 {
    /**
     * 题目：请实现一个函数，用来判断一颗二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null) return true;
        return mirror(pRoot.left, pRoot.right);
    }

    private boolean mirror(TreeNode l, TreeNode r) {
        if(l==null&&r==null) return true;
        if(l==null||r==null) return false;
        return l.val==r.val&&mirror(l.left,r.right)&&mirror(l.right,r.left);
    }
}
