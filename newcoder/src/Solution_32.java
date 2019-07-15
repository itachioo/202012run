public class Solution_32 {
	/**
	 * 题目：二叉树后续遍历
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		//递归解决，比较简单
        ArrayList<Integer> list = new ArrayList<>();
        traversalHelper(list, root);
        return list;
    }
    void traversalHelper(ArrayList<Integer> list, TreeNode root) {
    	if(root==null) return;
    	traversalHelper(list, root.left);
    	traversalHelper(list, root.right);
    	list.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
    //迭代解决
    	ArrayList<Integer> list = new ArrayList<>();
    	Stack<TreeNode> stack = new Stack<>();
    	if(root==null) return list;
    	stack.push(root);
    	while(!stack.isEmpty()) {
    		TreeNode node = stack.peek();
    		if(node.left==null&&node.right==null) {
    			stack.pop();
    			list.add(node.val);
    		}
    		if(node.right!=null) stack.push(node.right);
    		if(node.left!=null) stack.push(node.left);

    	}


    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}