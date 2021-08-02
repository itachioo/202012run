package hgang.code.TwoPoint;



//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
// 注意：答案中不可以包含重复的四元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = [], target = 0
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 200
// -109 <= nums[i] <= 109
// -109 <= target <= 109
//
// Related Topics 数组 双指针 排序
// 👍 917 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++) {
            if (i>0&&nums[i]==nums[i-1]) continue;
            for (int j=i+1;j<nums.length;j++) {
                if (j>i+1&&nums[j]==nums[j-1]) continue;
                int left = j+1;
                int right = nums.length-1;
                while (left<right) {
                    if (nums[i]+nums[j]+nums[left]+nums[right]>target) right--;
                    else if(nums[i]+nums[j]+nums[left]+nums[right]<target) left++;
                    else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        temp.add(left);
                        temp.add(right);
                        res.add(temp);
                        while (left<right&&nums[left]==nums[left+1]) left++;
                        while (left<right&&nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
