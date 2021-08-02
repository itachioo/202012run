package hgang.code.TwoPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针 排序
// 👍 3582 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //去重得先排个序
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++) {
            //排序后第一个数为正数，那三数之和不可能为0了
            if (nums[i]>0) return res;
            //第一个数去重
            if (i>0&&nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while (left<right) {
                if (nums[i]+nums[left]+nums[right]>0) right--;
                else if (nums[i]+nums[left]+nums[right]<0) left++;
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(left);
                    temp.add(right);
                    res.add(temp);
                    while (left<right&&nums[right]==nums[right-1]) right--;
                    while (left<right&&nums[left]==nums[left+1]) left++;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
