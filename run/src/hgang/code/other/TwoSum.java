package hgang.code.other;

//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice.
//
// You can return the answer in any order.
//
//
// Example 1:
//
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//
// Example 2:
//
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
//
// Example 3:
//
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
//
// Related Topics Array Hash Table
// 👍 18135 👎 647


import java.util.HashMap;
import java.util.Map;

public class TwoSum{
    public static void main(String[] args) {
        TwoSumSolution solution  = new TwoSumSolution();
        int[] nums = {3,2,4};
        solution.twoSum2(nums,6);

    }
    //leetcode submit region begin(Prohibit modification and deletion)

//leetcode submit region end(Prohibit modification and deletion)

}
class TwoSumSolution {
    //暴力查找所有两数之和
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        boolean flag = true;
        for (int i=0;i<nums.length;i++) {
            if (!flag) break;
            int one = nums[i];
            for (int j=i+1;j<nums.length;j++) {
                if (target-one==nums[j]) {
                    res[0] = i;
                    res[1] = j;
                    flag = false;
                    break;
                }
            }
        }
        return res;
    }
    public int[] twoSum2(int[] nums, int target) {
        //空间换时间，利用map常数时间查询特性，一次遍历数组得到结果
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++) {
            int one = nums[i];
            if (map.containsKey(target-one)) {
                res[0] = i;
                res[1] = map.get(target-one);
            }
        }
        return res;
    }
}