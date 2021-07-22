package hgang.code.other;

//Determine whether an integer is a palindrome. An integer is a palindrome when
//it reads the same backward as forward.
//
// Follow up: Could you solve it without converting the integer to a string?
//
//
// Example 1:
//
//
//Input: x = 121
//Output: true
//
//
// Example 2:
//
//
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
//
//
// Example 3:
//
//
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//
// Example 4:
//
//
//Input: x = -101
//Output: false
//
//
//
// Constraints:
//
//
// -231 <= x <= 231 - 1
//
// Related Topics Math
// 👍 2823 👎 1656

public class PalindromeNumber{
    public static void main(String[] args) {
        palindromeNumberSolution solution = new palindromeNumberSolution();
        System.out.println(solution.isPalindrome(1222));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

//leetcode submit region end(Prohibit modification and deletion)

}
class palindromeNumberSolution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int div = 1;
        // 计算div初始值，left初始值根据该值算得
        while(x/div>=10) {
            div *=10;
        }
        while(x>0) {
            int left = x / div;
            int right = x % 10;
            if(left!=right) return false;
            // x直观来看需要剔除掉两端的值，因为已经比较过了，如：1221 剔除两个1
            x = x % div /10;
            // div直观来看应减少两位，除100
            div = div / 100;
        }

        return true;
    }
}