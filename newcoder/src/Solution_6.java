import org.junit.jupiter.api.Test;

public class Solution_6 {
    /**
     * 输入某二叉树的后序遍历和中序遍历的结果，请重建出该二叉树。假设输入的后序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入后序遍历序列{7,4,2,5,8,6,3,1}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
     */
    public TreeNode reConstructBinaryTree(int [] post,int [] in) {
//        TreeNode root = findSubTree(pre,in,0,pre.length-1);
        TreeNode root = findSubTree2(post,0,post.length-1,in,0,in.length-1);
        return root;
    }

    private TreeNode findSubTree2(int[] post, int pStart , int pEnd, int[] in, int iStart, int iEnd) {
        if(pStart>pEnd || iStart>iEnd) return null;
        TreeNode root = new TreeNode(post[pEnd]);
        int plen = 0;
        for(int i=iEnd;i>=iStart;i--) {
            if(in[i]==post[pEnd]) {
                plen = iEnd-i;
                break;
            }
        }
        root.right = findSubTree2(post, pEnd-plen,pEnd-1,in, iEnd-plen+1,iEnd);
        root.left = findSubTree2(post,pStart,pEnd-plen-1,in, iStart, iEnd-plen-1);
        return root;
    }

    @Test
    public void test() {
        int[] post = {7,4,2,5,8,6,3,1};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(post, in);
        System.out.println(reConstructBinaryTree(post, in));
    }

}
