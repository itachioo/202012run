package hgang.code;

//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找
// 👍 563 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import com.sun.corba.se.impl.orb.ParserTable;

public class MySqrt{
    public static void main(String[] args) {
        mySqrtSolution solution = new mySqrtSolution();
        System.out.println(solution.mySqrt1(7));
    }

}


class mySqrtSolution {
    public int mySqrt(int x) {
        //虽然能pass，但逻辑不太清楚，有以下几点
        if(x<=1) return x;
        int low = 0;
        int high = x;
        int mid = (low+high)/2;  // 这么写容易溢出，正确写法：low + （high-low）/2
        while(mid>0) {    // 循环结束条件毫无意义，只要x不是0和1，这个条件就达不到，将其改为true照样可运行；
            if(mid-low==0) return low;
            if(mid * mid > x) {
                high = mid;
                mid = (low+high)/2;
            }
            else if (mid * mid==x) return mid;
            else {
                low = mid;
                mid = (low+high)/2;
            }
        }
        return 0;
    }
    public int mySqrt1(int x) {
        if (x<=1) return x;
        int low = 0;
        int high = x;
        while(low<high) {
            int mid = low + (high-low)/2;
            if (mid * mid > x) high = mid;
            else if (mid*mid==x) return mid;
            else low = mid+1;
        }

        return low;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

