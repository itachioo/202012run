public class Solution42 {
    /**
     * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e
     * 矩阵中包含一条字符串”bcced”的路径，但是矩阵中不包含”abcb”路径，因为字符串的第一个字符b占据了矩阵中
     * 的第一行第二个格子之后，路径不能再次进入该格子。
     */
    public boolean hasPath(char[] matrix, int row, int col, char[] str) {
        boolean[] flag = new boolean[matrix.length];
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                /*从一个元素开始，递归查找周围是否存在str中元素*/
                if(helper(matrix,row,col, i, j, str,0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int row, int col, int i, int j, char[] str, int k, boolean[] flag) {
        if(i<0 || j<0 || matrix[i*col+j]!=str[k]|| i>=row||j>=col) {
            return false;
        }
        flag[i*col+j] = true;
        if(k==str.length-1) return true;
        /* 递归检查上下左右的元素和str中的第k+1元素是否相同*/
        if(helper(matrix,row,col,i,j-1,str,k+1,flag)|| helper(matrix,row,col,i,j+1,str,k+1,flag)||
                helper(matrix,row,col,i-1,j,str,k+1,flag)||helper(matrix,row,col,i+1,j,str,k+1,flag)) {
            return true;
        }
        /*如果不同，则返回上一层继续*/
        flag[i*col+j] = false;
        return false;
    }
}
