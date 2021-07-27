package hgang.code.array;


//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
// Related Topics 数组 矩阵 模拟
// 👍 448 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int direction = 0;
        int row = 0;
        int col = 0;
        for (int i=1;i<=n*n;i++) {
            res[row][col] = i;
            int rowN = row + directions[direction][0];
            int colN = col + directions[direction][1];
            if(rowN>=n||rowN<0||colN>=n||colN<0||res[rowN][colN]!=0) {
                direction = (direction + 1)%4;
            }
            row += directions[direction][0];
            col += directions[direction][1];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
