package backTracking;//Given a collection of candidate numbers (candidates) and a target number (targ
//et), find all unique combinations in candidates where the candidate numbers sums
// to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: 
//
// 
// All numbers (including target) will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5,
//A solution set is:
//[
//  [1,2,2],
//  [5]
//]
// 
// Related Topics Array Backtracking

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2{
    public static void main(String[] args) {
        int[] can = {10,1,2,7,6,1,5};
        Arrays.sort(can);
        combinationSum2(can, 8);
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        process(candidates, target, res, path, 0, used);
        System.out.println(res);
        return res;
    }

    private static void process(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int start, boolean[] used) {
        if(target==0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if(target<0||start>=candidates.length) return;
        for(int i=start;i<candidates.length;i++) {
            if(i>0&&candidates[i]==candidates[i-1]&&!used[i-1]) continue;
            used[i] = true;
            path.add(candidates[i]);
            target -= candidates[i];
            process(candidates,target,res, path,i+1,used); // start用于排除掉重复的组合（可以参考CombinationSum解法理解其作用），
                                                                // used用来排除掉重复的元素导致的重复组合（可以结合permutation2解法来理解）
            path.remove(path.size()-1);
            target += candidates[i];
            used[i] = false;
        }
    }


}