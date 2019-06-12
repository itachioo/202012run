import org.junit.jupiter.api.Test;

public class Solution_9 {
    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     */
    public int NumberOf1(int n) {
        /**
         * 思路：利用位运算，1每次向左移动一位与n做与运算，结果不为0则n中包含1
         * flag左移32次后变为0
         * 复杂度：不管n二进制中有多少个1，都会循环32次
         */
        int flag = 1;
        int cnt = 0;
        while(flag!=0) {
            if((flag&n)!=0) cnt++;
            flag <<=1;
        }
        return cnt;
    }

    @Test
    public void NumberOf1test() {
        System.out.println(NumberOf1(-1));
    }

    public int NNumberOf1(int n) {
        /**
         * 思路2：n&(n-1) 会将n中最右边的1变为0，其他不变；
         * 复杂度：n的二进制中有多少1 就会循环多少次
         */
        int cnt = 0;
        while(n!=0) {
            cnt++;
            n = n&(n-1);
        }
        return cnt;
    }

    @Test
    public void NNumberOf1Test() {
        System.out.println(NNumberOf1(0));
    }
}
