public class Solution_45 {
    /**
     * 题目：给定一个非空整数数组，除某个元素只出现一次外，其他都出现了3次，找出只出现一次的元素；
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i=0;i<32;i++) {
            int sum = 0;
            for(int num:nums) {
                // 累加所有num第i位的值
                 sum += (num>>i)&1;
            }
            sum %= 3;
            res |=  (sum<<i);
        }
        return res;
    }
}
