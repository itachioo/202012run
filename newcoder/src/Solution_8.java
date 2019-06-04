import org.junit.jupiter.api.Test;

public class Solution_8 {
    /**
     * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     *       输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        /**
         * 思路：找到某个位置的值比前一个位置小，返回即可；否则，数组元素相等，返回第一个，时间复杂度O（N）
         */
        if(array.length==0) return 0;
        for(int i=1;i< array.length;i++) {
            if(array[i]<array[i-1]) return array[i];
        }
        return array[0];
    }

    public int minNumberInRotateArray1(int[] array) {
        /**
         * 思路：类似于二分法查找，分别用left、right指针指向数组起始和结束位置，找到中点mid位置；
         * 若mid>left,mid位于左侧非降序子数组中，最小值在其后面，移动left到mid位置，缩小查找范围；
         * 若mid < left, mid位于右侧非降序子数组中，最小值在其前面，移动right到mid位置，缩小查找范围；
         * 如此反复，直至left、right分别指向相邻的两个元素，终止。
         */
        return 0;

    }


    @Test
    public void test() {
        int[] arr = {1,1,1,1,1,1};
        System.out.println(minNumberInRotateArray(arr));
    }
}
