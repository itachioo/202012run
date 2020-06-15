package backTracking;

//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters.
//
//
//
// Example:
//
//
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// Note:
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want.
// Related Topics String Backtracking

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        String s = "24";
        letterCombinations(s);
    }



    public static List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> res = new ArrayList<>();
        String[] numToStr = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};
        process(res, "",  digits, numToStr, 0);
        System.out.println(res);
        return res;
    }

    private static void process(List<String> res, String out, String digits, String[] map, int index) {
        if(index==digits.length()) {
            res.add(out);
            return;
        }
        String str = map[Integer.parseInt(digits.substring(index,index+1))];
        for (int i=0;i<str.length();i++) {
            process(res, out+str.substring(i,i+1), digits, map, index+1);
        }
    }

}
