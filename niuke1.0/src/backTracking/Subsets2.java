package backTracking;

//Given a collection of integers that might contain duplicates, nums, return all
// possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
//Input: [1,2,2]
//Output:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
//
// Related Topics Array Backtracking

import java.util.ArrayList;
import java.util.List;

public class Subsets2{
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        subsetsWithDup(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        int subSize = nums.length;
        for(int i=0;i<=subSize;i++) {
            process(res, temp, nums, used, i, 0);
        }
        System.out.println(res);
        return res;
    }

    private static void process(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used, int subSize, int index) {
        if(temp.size()==subSize) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<nums.length;i++) {
           if(i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
           used[i] = true;
           temp.add(nums[i]);
           process(res,temp,nums,used,subSize,i+1);
           used[i] = false;
           temp.remove(temp.size()-1);
        }
    }



}
