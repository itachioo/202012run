package hgang.code.other;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划
// 👍 2733 👎 0

public class MaxSubArray{
    public static void main(String[] args) {
        int[] arr = {-2};
        maxSubArraySolution1 solution = new maxSubArraySolution1();
        System.out.println(solution.maxSubArray(arr));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class maxSubArraySolution {
    public int maxSubArray(int[] nums) {
        // 暴力解决：遍历所有子数组组合，记录和最大值
        int res = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++) {
            int curSum = 0;
            for(int j=i;j<nums.length;j++) {
                curSum += nums[j];
                res = Math.max(curSum, res);
            }
        }
        return res;
    }
}

class maxSubArraySolution1 {
    //分治思路：分治思路将打问题分解为相同类型的小问题，本题中可将数组一分为二，此时数组最大子数组，无非三种情况：
    //1、最大子数组在左区间[left,mid],2、在右区间[mid+1,right]，3、包含mid的区间[i,j], left<=i<j<=right
    //显然，1、2的解可以接着递归求解，直至区间长度变为1，得到当前解，递归回升，得到上层解，直至得到原数组解；3、的解可以直接从mid遍历数组得到；
    public int maxSubArray(int[] nums) {
        return process(nums, 0, nums.length-1);

    }
    public int process(int[] nums, int left, int right) {
        if (left==right) {
            return nums[left];
        }
        int mid = (left+right) >> 1;
        int leftMax = process(nums, left, mid);
        int rightMax = process(nums, mid+1, right);
        int midMax = findMidMax(nums, mid, left, right);
        return Math.max(Math.max(leftMax,rightMax), midMax);
    }

    public int findMidMax(int[]nums, int mid, int left, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum=0;
        for (int i=mid;i>=left;i--) {
            sum += nums[i];
            if(leftSum<sum) leftSum = sum;
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i=mid+1; i<=right;i++) {
            sum += nums[i];
            if(rightSum<sum) rightSum = sum;
        }
        return leftSum + rightSum;
    }

}
