import java.util.LinkedList;
import java.util.Queue;

public class Solution_15 {
    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null) return false;
        int val = root2.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            if(node.val==val) {
                boolean res = treeContain(node,root2);
                if(res) return true;
            }
        }
        return false;
    }


    public boolean treeContain(TreeNode a, TreeNode b) {
        if(b==null) return true;
        if(a!=null){
            if(a.val != b.val) return false;
            else return treeContain(a.left,b.left)&& treeContain(a.right,b.right);
        }
        else
            return false;

    }

    public boolean treeEqual(TreeNode a, TreeNode b) {
        if(b==null) return a==null;
        if(a==null) return false;
        if(a.val!=b.val) return false;
        return treeEqual(a.left,b.left)&&treeEqual(a.right,b.right);
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

