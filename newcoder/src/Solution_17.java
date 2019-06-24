import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Solution_17 {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 。
     *
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     */

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        ArrayList<Integer> res = new ArrayList<>();
//        int round = (Math.min(n+1,m+1)+1)>>1;
        for(int i=0;i<=n-i&&i<=m-i;i++) {
            for(int l=i;l<=m-i;l++) {
                res.add(matrix[i][l]);
            }
            for(int k=i+1;k<=n-i;k++) {
                res.add(matrix[k][m-i]);
            }
            for(int o=m-i-1;o>=i&&n-i!=i;o--) {
                res.add(matrix[n-i][o]);
            }
            for(int p=n-i-1;p>=i+1&&i!=m-i;p--) {
                res.add(matrix[p][i]);
            }
        }
        return res;
    }

    @Test
    public void printMatrixTest() {
        int[][] matrix = {{1,2,3,4}};
        ArrayList<Integer> res = printMatrix(matrix);
        for (int i:res) {
            System.out.println(i);
        }
    }
}
