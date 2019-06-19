import org.junit.jupiter.api.Test;

public class Solution_11 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分,
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public void reOrderArray(int [] array) {
        /**
         * 思路1：用一个额外的数组，分别将奇数偶数复制过去,时间复杂度 O(N)
         */
        int len = array.length;
        int[] array1 = new int[len];
        int j=0;
        for(int i=0;i<len;i++) {
            if((array[i]%2)!=0) array1[j++] = array[i];
        }
        for (int i=0;i<len;i++) {
            if(array[i]%2==0) array1[j++] = array[i];
        }
        for (int i=0;i<len;i++) {
            array[i] = array1[i];
        }
        for (int i=0;i<len;i++) {
            System.out.println(array[i]);
        }

    }

    @Test
    public void reOrderArrayTest() {
        int[] arr = {1,2,3,4,5,6,7,8};
        reOrderArray(arr);
    }
}
