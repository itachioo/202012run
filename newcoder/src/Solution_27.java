public class Solution_27 {
    /**
     * 题目：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null) return pNode;
        if(pNode.right!=null) {
            return MostLeft(pNode.right);
        }
        else {
            if(pNode.next!=null&&pNode==pNode.next.left) return pNode.next;
            else{
                TreeLinkNode parent = pNode.next;
                while(parent!=null&&parent.left!=pNode) {
                    pNode = parent;
                    parent = parent.next;
                }
                return parent;
            }
        }
    }

    private TreeLinkNode MostLeft(TreeLinkNode node) {
        TreeLinkNode pre = null;
        while (node!=null) {
            pre = node;
            node = node.left;
        }
        return pre;
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}