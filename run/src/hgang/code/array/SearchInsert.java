package hgang.code.array;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,3,5,6], target = 5
//输出: 2
//
//
// 示例 2:
//
//
//输入: nums = [1,3,5,6], target = 2
//输出: 1
//
//
// 示例 3:
//
//
//输入: nums = [1,3,5,6], target = 7
//输出: 4
//
//
// 示例 4:
//
//
//输入: nums = [1,3,5,6], target = 0
//输出: 0
//
//
// 示例 5:
//
//
//输入: nums = [1], target = 0
//输出: 0
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums 为无重复元素的升序排列数组
// -104 <= target <= 104
//
// Related Topics 数组 二分查找
// 👍 974 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
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
    public static void main(String[]args) {
        System.out.print(Character.toChars('a'+5));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


