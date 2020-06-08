package backTracking;

//
// Find all possible combinations of k numbers that add up to a number n, given
//that only numbers from 1 to 9 can be used and each combination should be a uniqu
//e set of numbers.
//
// Note:
//
//
// All numbers will be positive integers.
// The solution set must not contain duplicate combinations.
//
//
// Example 1:
//
//
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//
//
// Example 2:
//
//
//Input: k = 3, n = 9
//Output: [[1,2,6], [1,3,5], [2,3,4]]
//
// Related Topics Array Backtracking

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3{
    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        combinationSum3(k, n);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        process(res, temp, k, n, n,1);
        System.out.println(res);
        return res;
    }

    private static void process(List<List<Integer>> res, List<Integer> temp, int k, int n, int end, int index) {
        if(temp.size()==k&&n==0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(temp.size()>k) return;
        if(n<0) return;
        for(int i=index;i<end;i++) {
            temp.add(i);
            n -= i;
            process(res, temp, k, n, end,i+1);
            temp.remove(temp.size()-1);
            n += i;
        }
    }

}