package hgang.code.other;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid.
//
// An input string is valid if:
//
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
//
// Example 1:
//
//
//Input: s = "()"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "()[]{}"
//Output: true
//
//
// Example 3:
//
//
//Input: s = "(]"
//Output: false
//
//
// Example 4:
//
//
//Input: s = "([)]"
//Output: false
//
//
// Example 5:
//
//
//Input: s = "{[]}"
//Output: true
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
//
// Related Topics String Stack
// 👍 6215 👎 253

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

        ValidParenthesesSolution solution = new ValidParenthesesSolution();
        System.out.println(solution.isValid(")"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
//leetcode submit region end(Prohibit modification and deletion)


class ValidParenthesesSolution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        Map<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");
        int len = s.length();
        for(int i=0;i<len;i++) {
            String tmp = String.valueOf(s.charAt(i));
            if (map.containsKey(tmp)) stack.push(tmp);
            else {
                if(!stack.empty()) {
                    String topS = stack.pop();
                    if (!tmp.equals(map.get(topS))) return false;
                }
                else return false;
            }
        }
        if (!stack.empty()) return false;
        return true;
    }
}