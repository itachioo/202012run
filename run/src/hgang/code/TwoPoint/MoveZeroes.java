package hgang.code.TwoPoint;



//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 1152 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//283、移动0
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right<nums.length) {
            if (nums[left]==0) {
                while (right<nums.length&&nums[right]==0) right++;
                if (right<nums.length) {
                    nums[left] = nums[right];
                    nums[right] = 0;
                    left ++;
                }
            }
            else {
                left++;
                right++;
            }

        }
    }
    public static void moveZeroes1(int[] nums) {
        int left = 0;
        int right = 0;
        while (right<nums.length) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left ++;
            }
            right++;

        }
    }
    public static void main(String[]args) {
        int[] nums = {0,0,0,0,0};
        moveZeroes(nums);
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
