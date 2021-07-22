package hgang.code.other;

//Given a 32-bit signed integer, reverse digits of an integer.
//
// Note:
//Assume we are dealing with an environment that could only store integers withi
//n the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this prob
//lem, assume that your function returns 0 when the reversed integer overflows.
//
//
// Example 1:
// Input: x = 123
//Output: 321
// Example 2:
// Input: x = -123
//Output: -321
// Example 3:
// Input: x = 120
//Output: 21
// Example 4:
// Input: x = 0
//Output: 0
//
//
// Constraints:
//
//
// -231 <= x <= 231 - 1
//
// Related Topics Math
// 👍 4057 👎 6279

public class ReverseInteger{
    public static void main(String[] args) {
        reverseIntegerSolution solution = new reverseIntegerSolution();
        solution.reverse(-123);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

//leetcode submit region end(Prohibit modification and deletion)

}

class reverseIntegerSolution {
    public int reverse(int x) {
        int res = 0;
        while (x!=0) {
            //此处特别注意，要判断Integer.MAX_VALUE / 10，直接判断Integer.MAX_VALUE，有可能res还是overflow
            if(Math.abs(res) > (Integer.MAX_VALUE / 10)) return 0;

            //取余操作得到整数最后一位，取整操作去掉整数最后一位

            res = res *10 + x % 10;
            x = x /10;
        }
        return res;
    }
}