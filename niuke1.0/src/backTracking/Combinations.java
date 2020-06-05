package backTracking;
//Given two integers n and k, return all possible combinations of k numbers out
//of 1 ... n.
//
// Example:
//
//
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// Related Topics Backtracking

import java.util.ArrayList;
import java.util.List;

public class Combinations{
    public static void main(String[] args) {
        combine(4,2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        process(res, n, k, 1, temp);
        System.out.println(res);
        return res;
    }

    private static void process( List<List<Integer>> res, int n, int k, int index, List<Integer> temp) {
        if(temp.size()==k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<=n;i++) {
            temp.add(i);
            process(res, n,k,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}
