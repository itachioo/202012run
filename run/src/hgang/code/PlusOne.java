package hgang.code;

//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组
// 👍 604 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

public class PlusOne{
    public static void main(String[] args) {
        int[] dights = {1,2,3};
        PlusOneSolution solution = new PlusOneSolution();
        System.out.println(solution.plusOne(dights));
    }

}

class PlusOneSolution {
    //思路：主要需要考虑有没有进位问题，看了题解可直接判断当前位和9的大小关系；
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] out = new int[len+1];
        int carry = (digits[len-1] + 1) /10 ;
        digits[len-1] = (digits[len-1] + 1) %10 ;
        int remain = 0;
        for (int i=len-2;i>=0;i--) {
               remain = (digits[i] + carry) %10;
               carry = (digits[i] + carry)/10;
               digits[i] = remain;
        }
        if(carry>0) {
            System.arraycopy(digits,0,out,1,len);
            out[0] = carry;
        }else {
            return digits;
        }
        return out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
