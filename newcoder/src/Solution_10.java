import org.junit.jupiter.api.Test;

public class Solution_10 {
    /**
     * 题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     */
    public double Power(double base, int exponent) {
        /**
         * 思路1：直接base累乘，但是若exponent为负数,则结果为1，无法cover负指数的情况。
         */
        double res = 1;
        int exp = 0;
        if(exponent==Integer.MIN_VALUE) {
            exp = Integer.MAX_VALUE;
        }
        else if(exponent < 0) {
            exp = Math.abs(exponent);
        }
        for(int i=0;i<exponent;i++) {
            res *= base;
        }
        return base;
    }

    public double Power1(double base, int exponent) {
        /**
         * 思路2：先求出指数的一半次幂的值，可以递归求出
         */
        double res = 0;
        if(exponent==0) return 1;
        int exp = 0;
        if(exponent<0) {
            if(exponent == Integer.MIN_VALUE) exp = Integer.MAX_VALUE;
            else
                exp = Math.abs(exponent);
        }
        else exp = exponent;
        if(exp%2==0)
            if(exponent>0)
                res = Power1(base, (exp)/2)*Power1(base, (exp)/2);
            else
                if(exp==Integer.MAX_VALUE)
                    res = 1/(Power1(base, (exp)/2)*Power1(base, (exp)/2)*base);
                else
                    res = 1/(Power1(base, (exp)/2)*Power1(base, (exp)/2));
        else {
            if(exponent>0)
                res = base*Power1(base, exp/2 )* Power1(base, exp/2);
            else
                if(exp==Integer.MAX_VALUE)
                    res = 1/(base*Power1(base, exp/2) * Power1(base, exp)/2)*base;
                else
                    res = 1/(base*Power1(base, exp/2) * Power1(base, exp/2));
        }

        return res;

    }

    public double mypow(double base, int exponent) {
        /**
         * 对上面的写法进行了拆分，增强可阅读性
         */
        if(exponent<0) {
            if(exponent==Integer.MIN_VALUE) {
                return 1/(Power2(base,Integer.MAX_VALUE)*base);
            }
            return 1/Power2(base,Math.abs(exponent));
        }
        return Power2(base,exponent);
    }
    public double Power2(double x, int n) {
        if(n==0) return 1;
        double half = Power2(x,n/2);
        if(n%2==0)
            return half*half;
        else
            return x*half*half;
    }

    public double Power3(double x, int n) {
        /**
         * 思路：快速幂，时间复杂度：O（lg n），将指数n转化为二进制形式，比如x的11次方，11二进制表示为：1011，
         * 只需要求x的2的0次（1），x的2的1次（2），x的2的3次（8）.
         */
        if(n==0) return 1;
        if(n<0) {
            if(n==Integer.MIN_VALUE) {
                return 1/(Power3(x,Integer.MAX_VALUE) * x);
            }
            return 1/Power3(x,-n);
        }
        double res = 1;
        while(n!=0) {
            if((n&1)!=0) {
                res *= x;
            }
            x *= x;
            n >>=1;
        }
        return res;
    }

    @Test
    public void Power1Test(){
        System.out.println(Power3(2,-3));
    }
}
