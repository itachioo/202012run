public class Solution_31 {
	/**
	 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树
	 */
	String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serHelper(sb, root);
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	void serHelper(StringBuilder sb, TreeNode root) {
		if(root==null) {
			sb.append("#,");
			return;
		}
		sb.append(root.val+",");
		serHelper(sb, root.left);
		serHelper(sb,root.right);

	}


	TreeNode Deserialize(String str) {
		if(str==null||str.length()==0) return null;
		String[] arr = str.split(",");
		int[] idx = new int[1];
		return deserHelper(arr,idx);

	}

	TreeNode deserHelper(String[] arr,int[] idx) {
		//if(idx[0]>=arr.length) return null;
		if(arr[idx[0]].equals("#")) return null;
		TreeNode root = new TreeNode(Integer.parseInt(arr[idx[0]]));
		idx[0]++;
		root.left = deserHelper(arr,idx);
		idx[0]++;
		root.right = deserHelper(arr, idx);
		return root;
	}
}