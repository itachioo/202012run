public class Solution_46 {
    /**
     * 题目：给定两个整数，被除数dividend和除数divisor，将两数相除，要求不使用乘法、除法、mod运算符
     * 返回被除数除以除数的商
     * leetcode 29
     */
    public int divide(int dividend, int divisor) {
        if(divisor==0||(dividend==Integer.MIN_VALUE&&divisor==-1)) return Integer.MAX_VALUE;
        int sign = ((dividend<0)^(divisor<0))? -1 : 1;
        long divisor_abs = Math.abs((long) divisor);
        long dividend_abs = Math.abs((long) dividend);
        int res = 0;
        while(dividend_abs>=divisor_abs) {
            int shift = 1;
            while(dividend_abs>=(divisor_abs<<shift)) {
                shift++;
            }
            dividend_abs -= divisor_abs<<(shift-1);
            res += 1<<(shift-1);
        }
        return res*sign;
    }
}
