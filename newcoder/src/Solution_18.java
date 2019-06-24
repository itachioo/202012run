import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

public class Solution_18 {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     */
    Stack<Integer> oristack = new Stack<>();
    TreeMap<Integer, Integer> map1 = new TreeMap<>();
    public void push(int node) {
        oristack.push(node);
        if(map1.containsKey(node))
            map1.put(node,map1.get(node)+1);
        else
            map1.put(node,1);
    }

    public void pop() {
        if(!oristack.isEmpty()){
            int pop = oristack.pop();
            if(map1.containsKey(pop)) {
                if(map1.get(pop)==0) map1.remove(pop);
                else  map1.put(pop,map1.get(pop)-1);
            }
        }
    }

    public int top() {
        if (oristack.isEmpty())
            throw new RuntimeException("stack is empty!");

        int pop1 = oristack.peek();
        return pop1;


    }

    public int min() {
        if(map1.get(map1.firstKey())==0) map1.remove(map1.firstKey());
        return map1.firstKey();
    }

    @Test
    public void testStack(){
        push(3);
        System.out.println(min());
        push(4);
        System.out.println(min());
        push(2);
        System.out.println(min());
        push(3);
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        push(0);
        System.out.println(min());
    }
//    ["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
}
