public class Solution_44 {
    /**
     * 题目：给定一个非空数组，除了某个元素只出现一次外，其余元素均出现两次，找出只出现一次的元素
     */
    public int singleNumber(int[] nums) {
        /*思路：利用异或运算的性质 ： 0 ^ n = n  n^n = 0 */
        int res = 0;
        for (Integer num: nums) {
            res ^= num;
        }
        return res;
    }
}
