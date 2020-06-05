package backTracking;//Given a set of candidate numbers (candidates) (without duplicates) and a targe
//t number (target), find all unique combinations in candidates where the candidat
//e numbers sums to target. 
//
// The same repeated number may be chosen from candidates unlimited number of ti
//mes. 
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
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// 
// Related Topics Array Backtracking

import java.util.ArrayList;
import java.util.List;

public class CombinationSum{
    public static void main(String[] args) {
        int[] can = {2,3,5};
         combinationSum(can,8);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int curSum = 0;
        process(candidates, target, res, path, curSum,0);
        System.out.println(res);
        return res;
    }

    private static void process(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int curSum, int start) {
            if(curSum==target) {
                res.add(new ArrayList<>(path));
                return;
            }
            if(curSum>target) return;
            for (int i=start;i<candidates.length;i++) {
                path.add(candidates[i]);
                curSum += candidates[i];
                process(candidates,target, res, path, curSum, i);  // 此处 位置使用 还不熟练，去掉最后一个参数process（candidates,target,res,path,curSum）
                                                                  // ，就会有重复的组合,如，（3，5），（5，3）
                path.remove(path.size()-1);
                curSum -= candidates[i];
            }
    }

//leetcode submit region end(Prohibit modification and deletion)

}