import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class Solution_30 {
	/**
	 * 题目： 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
	 */
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	 Queue<TreeNode> queue = new LinkedList<>();
    	 ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    	 if(pRoot==null) return res;
    	 queue.offer(pRoot);
    	 while(!queue1.isEmpty()) {
    	 	ArrayList<Integer> temp = new ArrayList<>();
    	    int cnt = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
    	 	
    	 	if(temp.size()!=0) res.add(new ArrayList<>(temp));
    	 }
    	 return res;

    }
	
}