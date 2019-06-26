import java.util.HashMap;

public class Solution_23 {
    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
     * ，返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */
    public RandomListNode Clone(RandomListNode pHead) {
        /**
         * 思路：用hashmap记录复杂链表的节点及其对应的副本，然后根据对应关系依次设置副本的next、random指针，
         * 使用了额外空间，时间复杂度O（N）
         */
        if(pHead==null) return pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode head1 = pHead;
        RandomListNode dummy = new RandomListNode(0);
        while(head1!=null) {
            RandomListNode node = new RandomListNode(head1.label);
            map.put(head1,node);
            head1 = head1.next;
        }

        head1 = pHead;
        while(head1!=null) {
            map.get(head1).next = map.get(head1.next);
            map.get(head1).random = map.get(head1.random);
            head1 = head1.next;
        }
        return map.get(pHead);
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