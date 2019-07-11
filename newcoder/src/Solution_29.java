import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_29 {
	/**
	 * 题目：请实现一个函数按照之字形打印二叉树，
	 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
	 */ 
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(pRoot==null) return res;
		queue.offer(pRoot);
		int line = 0;
		while(!queue.isEmpty()) {
			ArrayList<Integer> temp = new ArrayList<>();
			int cnt = queue.size();
			for(int i=0;i<cnt;i++) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
			}
			if(line%2==0) 
				res.add(new ArrayList<>(temp));
			else {
				Collections.reverse(temp);
				res.add(new ArrayList<>(temp));
			}
			line++;
			
		}
		return res;

	}
}