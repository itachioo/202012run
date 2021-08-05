package hgang.code.strings;


//给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
//
//
// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
//
//
//
// 示例 1：
//
//
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
//
//
// 示例 2：
//
//
//输入：s = "abcd", k = 2
//输出："bacd"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由小写英文组成
// 1 <= k <= 104
//
// Related Topics 双指针 字符串
// 👍 138 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] cha = s.toCharArray();
        for (int start=0; start<cha.length;start+=2*k) {
            int i=start;
            int j=Math.min(start+k-1,cha.length-1);
            while (i<j){
                char temp = cha[j];
                cha[j] = cha[i];
                cha[i] = temp;
                i++;
                j--;
            }
        }
        return new String(cha);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
