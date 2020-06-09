package backTracking;

//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
//
//
//
//For example, given n = 3, a solution set is:
//
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis{
    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n);
    }


    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String out = "";
        process(res, out, n, n);
        System.out.println(res);
        return res;
    }

    private static void process(List<String> res, String out, int left, int right) {
        if(left>right) return;
        if(left==0&&right==0) {
            res.add(out);
            return;
        }
        if(left>0) {
            process(res, out+"(", left-1, right);
        }
        if (right>0) {
            process(res, out+")", left, right-1);
        }
    }


}
