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
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(pRoot==null) return res;
		queue1.offer(pRoot);
		while(!queue1.isEmpty()||!queue2.isEmpty()) {
			ArrayList<Integer> temp1 = new ArrayList<>();
			while(!queue1.isEmpty()) {
				TreeNode node = queue1.poll();
				temp1.add(node.val);
				if(node.left!=null) queue2.offer(node.left);
				if(node.right!=null) queue2.offer(node.right);
			}
			if(temp1.size()!=0) res.add(new ArrayList<>(temp1));
			ArrayList<Integer> temp2 = new ArrayList<>();
			while(!queue2.isEmpty()) {
				TreeNode node1 = queue2.poll();
				temp2.add(node1.val);
				if(node1.left!=null) queue1.offer(node1.left);
				if(node1.right!=null) queue1.offer(node1.right);
			}
			Collections.reverse(temp2);
			if(temp2.size()!=0)  res.add(new ArrayList<>(temp2));
		}
		return res;

	}
}