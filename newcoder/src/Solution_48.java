public class Solution_48 {
    /**
     * 问题：在数组中找出出现次数超过一半的元素，数组非空，超过一半的元素必然存在
     */
    public int majorityElement(int[] nums) {
        int res = 0;
        int[] bitmap = new int[32];
        //统计所有num在每一位上1的个数
        for (int num : nums) {
            for (int i=0;i<32;i++) {
                if(((num>>i)&1)==1) {
                    bitmap[i] +=1;
                }
            }
        }
        /**每一位上1超过半数的就是要找的众数的i位*/
        for (int i=0;i<32;i++) {
            int bit = bitmap[i] > nums.length/2 ? 1 : 0;
            res += bit * (1<<i);
        }
        return res;
    }
}
