package hgang.code.array;
import java.util.ArrayList;
import java.util.List;


//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组 矩阵 模拟
// 👍 825 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0) return list;
        int row = matrix.length;
        int col = matrix[0].length;
        int num = row * col;
        int[][] derictions = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] used = new boolean[row][col];
        int m = 0;
        int n = 0;
        int direction = 0;
        for (int i=0;i<num;i++) {
            list.add(matrix[m][n]);
            used[m][n] = true;
            int mNext = m + derictions[direction][0];
            int nNext = n + derictions[direction][1];
            if(mNext>=row || mNext<0 || nNext>=col || nNext <0 || used[mNext][nNext]) {
                direction = (direction +1)%4;
            }
            m += derictions[direction][0];
            n += derictions[direction][1];
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
