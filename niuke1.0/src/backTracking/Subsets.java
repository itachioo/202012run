package backTracking;

//Given a set of distinct integers, nums, return all possible subsets (the power
// set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics Array Backtracking Bit Manipulation

import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int subSize = nums.length;
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<=subSize;i++) {
            process(res, temp, nums, 0, i);
        }
        System.out.println(res);
        return res;

    }

    private static void process(List<List<Integer>> res, List<Integer> temp, int[] nums, int index, int subSize) {
        if(temp.size()== subSize) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<nums.length;i++) {
            temp.add(nums[i]);
            process(res, temp, nums, i+1, subSize);
            temp.remove(temp.size()-1);
        }
    }
}