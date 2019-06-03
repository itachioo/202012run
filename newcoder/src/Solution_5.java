import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

public class Solution_5 {
    int pleft = 0;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
//        TreeNode root = findSubTree(pre,in,0,pre.length-1);
        TreeNode root = findSubTree1(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    public TreeNode findSubTree(int[] pre, int[] in, int leftStart, int leftEnd) {
        if(leftStart>leftEnd) return null;
        TreeNode root = new TreeNode(pre[pleft]);
        int index;
        for(index=leftStart; index<=leftEnd;index++) {
            if (in[index] == pre[pleft]) {
                pleft++;
                break;
            }
        }
        root.left = findSubTree(pre, in, leftStart, index-1);
        root.right = findSubTree(pre,in, index+1,leftEnd);
        return root;

//        root.left = new TreeNode(pre, )
    }

    public TreeNode findSubTree1 (int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int prelen = 0;
        for(int i=inStart; i<=inEnd; i++) {
            if(in[i]==pre[preStart]) {
                prelen = i-inStart;
                break;
            }
        }
        root.left = findSubTree1(pre, preStart+1, preStart+prelen, in, inStart, inStart+prelen-1);
        root.right = findSubTree1(pre,preStart+prelen+1, preEnd, in, inStart+prelen+1, inEnd);
        return root;
    }

    @Test
    public void test() {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.println(reConstructBinaryTree(pre, in));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}