package hgang.code;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串
// 👍 1386 👎 0

import java.util.Arrays;

public class LongestCommonPrefix{
    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        longestCommonPrefixSolution solution = new longestCommonPrefixSolution();
        System.out.println(solution.longestCommonPrefix2(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

//leetcode submit region end(Prohibit modification and deletion)

}

//leetcode submit region begin(Prohibit modification and deletion)
class longestCommonPrefixSolution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        boolean flag = true;
        for (int i=0;i<strs[0].length();i++) {
            if(!flag) return res;
            String tmp = String.valueOf(strs[0].charAt(i));
            //用第一个字符串的字符依次和其他字符串相同位置的字符对比
            int j=1;
            while(j<strs.length&&strs[j].length()>i){
                String end = String.valueOf(strs[j].charAt(i));
                if (!tmp.equals(end)) {
                    flag = false;
                    break;
                }
                j++;
            }
            if(flag) res += tmp;

        }
        return res;
    }

    public String longestCommonPrefix1(String[] strs) {
        //longestCommonPrefix1 对上述解法进行了精简，多层循环，结束最外层循环，也可直接return，解法一设置了flag，写法繁复
        String res = "";
        for (int i=0;i<strs[0].length();i++) {
            for (int j=1;j<strs.length;j++) {
                if (i>strs[j].length()||strs[j].charAt(i)!=strs[0].charAt(i)) return res;
            }
            res += String.valueOf(strs[0].charAt(i));
        }
        return res;
    }

    public String longestCommonPrefix2(String[] strs) {
        // 思路：先对字符串数组排序，字母序的字符串找最长前缀，找首尾两个字符串的公共前缀即可
        String res = "";
        Arrays.sort(strs);
        int len = Math.min(strs[0].length(),strs[strs.length-1].length());
        for (int i=0;i<len;i++) {
            if (strs[0].charAt(i)!=strs[strs.length-1].charAt(i)) {
                res = strs[0].substring(0,i);
                return res;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
