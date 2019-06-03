import org.junit.jupiter.api.Test;

public class Solution_2 {
    /**
    * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组
    * 和一个整数，判断数组中是否含有该整数
     * 思路：从右上角开始查找，1、等于的话，万事大吉；2、元素大于target，可排除最后一列；3、小于，可排除第一行，如此循环。　
    **/
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length&&col>=0) {
            int cur = matrix[row][col];
            if(cur==target) return true;
            else if(cur>target) col--;
            else row++;
        }
        return false;
    }
    @Test
    public void testSearchMatrix() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(searchMatrix(matrix, 15));
    }
}
