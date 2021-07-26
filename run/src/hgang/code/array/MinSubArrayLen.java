package hgang.code.array;

//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
// 示例 2：
//
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//
//
// 示例 3：
//
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= target <= 109
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 105
//
//
//
//
// 进阶：
//
//
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
//
// Related Topics 数组 二分查找 前缀和 滑动窗口
// 👍 696 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
public class MinSubArrayLen {
    //
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++) {
            int res = 0;
            for (int j=i;j<nums.length;j++) {
                res +=nums[j];
                if (res>=target) {
                    len  = Math.min(len,j-i+1);
                    break;
                }
            }
        }
        return len == Integer.MAX_VALUE ? 0:len;
    }
    // O(N)
    public int minSubArrayLen1(int target, int[] nums) {
        int sum=0;
        int i=0;
        int len = Integer.MAX_VALUE;
        for (int j=0;j<nums.length;j++) {
            sum += nums[j];
            while (sum>=target) {
                len = Math.min(len,j-i+1);
                sum -=nums[i];
                i++;
            }
        }
        return len== Integer.MAX_VALUE? 0:len;
    }

    //O(NlogN)
    public int minSubArraylen2(int target, int[] nums) {
        int[] sums= new int[nums.length+1];
        int len = Integer.MAX_VALUE;
        for (int i=1;i<=nums.length;i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        for (int i=0;i<sums.length;i++) {
            int s = sums[i] + target;
            int index = binarysearch(sums, s);
            if(index<0) {
                index = ~index;
                return index-i+1;
            }
            if(index==nums.length+1) break;
            if (len>index-i) len = index-i;
        }
        return len == Integer.MAX_VALUE?0:len;
    }

    public int binarysearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l<=r) {
            int mid = l + (r-l)/2;
            if (nums[mid]>target)  r = mid -1;
            else if(nums[mid] == target) return mid;
            else l = mid+1;
        }
        return l ;
    }

}

//leetcode submit region end(Prohibit modification and deletion)


