import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Solution_22 {
    /**
     * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        ArrayList<Integer> temp = new ArrayList<>();
        process(root,res, temp,target);
        return res;
    }

    public void process(TreeNode node,ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp,int target) {
        if(node==null) {
            return;
        }
        temp.add(node.val);
        target = target - node.val;
        TreeNode l = node.left;
        TreeNode r = node.right;
        if(l==null&&r==null) {
            if(target==0) {
                res.add(new ArrayList<Integer>(temp));
            }

            temp.remove(temp.size()-1);
            return;

        }
        process(l, res, temp, target);
        process(r, res,temp, target);
        temp.remove(temp.size()-1);


    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(10);
        TreeNode l = new TreeNode(5);
        TreeNode r = new TreeNode(12);
        TreeNode ll = new TreeNode(7);
        root.left = l;
        root.right = r;
        l.left = ll;
        ArrayList<ArrayList<Integer>> res = FindPath(root, 22);
        System.out.println(11);
    }
}
