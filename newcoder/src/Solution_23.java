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

    public RandomListNode Clone1(RandomListNode pHead) {
        /**
         * 思路：把当前节点的副本放到当前节点和下一个节点之间，作用其实与map一样，
         * 当前节点 副本节点的next 就是当前节点next节点的next，random就是当前节点
         * random节点的next节点。
         * 空间复杂度 ？？？
         */
        if(pHead==null) return pHead;
        RandomListNode cur = pHead;
        //将当前节点的副本放到cur 和 next之间
        while(cur!=null) {
            RandomListNode curNext = cur.next;
            RandomListNode node = new RandomListNode(cur.label);
            cur.next = node;
            node.next = curNext;
            cur = curNext;
        }
        cur = pHead;
        //修改副本节点的random节点
        while(cur!=null) {
            RandomListNode curRandom = cur.random;
            cur.next.random = curRandom !=null ? curRandom.next : null;
            cur = cur.next.next;
        }
        cur = pHead;
        RandomListNode next = null;
        RandomListNode copyCur = null;
        RandomListNode head = pHead.next;
        //修改副本节点的next节点
        while(cur!=null) {
            next = cur.next.next;
            copyCur = cur.next;
            cur.next = next;
            copyCur.next = next!=null ? next.next : null;
            cur = cur.next;
        }
        return head;
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