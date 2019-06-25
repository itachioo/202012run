public class Solution_23 {
    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
     * ，返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null) return pHead;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode node = new RandomListNode(pHead.label);
        dummy.next = node;
        RandomListNode head = pHead;
        while(head !=null) {
            if(head.next!=null) node.next = new RandomListNode(head.next.label);
//            if(head.random!=null) node.random = new RandomListNode(head.random.label);
            head = head.next;
            node = node.next;
        }
//        RandomListNode node1 = dummy.next;
//        while(pHead!=null) {
//            node1.random =
//        }
        return dummy.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}