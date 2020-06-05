package backTracking;//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Permutation2{
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        //先排序，这里就不写了
        permuteUnique(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        process(res, temp, nums, used);
        System.out.println(res);
        return res;
    }
    public static List<List<Integer>> process( List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size()>=nums.length) {
            res.add(new ArrayList<>(temp));
            return res;
        }
        for(int i=0;i<nums.length;i++) {
            if(used[i]) continue;    //已经用过的，直接跳过
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) {
               continue;     // 重复的，直接跳过
            }
            //递归前后代码高度对称
            used[i] = true;
            temp.add(nums[i]);
            process(res, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size()-1);

        }
        return res;
    }
}

