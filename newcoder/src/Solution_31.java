public class Solution_31 {
	/**
	 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树
	 */
	StringBuilder sb = new StringBuilder();
	String Serialize(TreeNode root) {
        if(root==null) return sb.toString();
        sb.append(root.val+",");
        Serialize(root.left);
        if(root.right!=null&& root.left==null) sb.append("#,");
        Serialize(root.right);
        if(root.left!=null&& root.right==null) sb.append("#,");
        return sb.toString();
  	}


    TreeNode Deserialize(String str) {

    	TreeNode root = null;
    	if(str==null||str.length()==0) return root;
    	for(int i=0;i<str.length();i++) {
    		root = new TreeNode(Integer.parseInt(str.subString(i,i+1)));
    	}
    	
  	}
}