public class Solution_47 {
    /**
     * 题目：计算两个整数之间的汉明距离，0<=x, y<2^31
     * leetcode 461
     */
    public int hanmingDistance(int x, int y) {
        int res = 0;
        for(int i=0;i<32;i++) {
            if(((x&1)^(y&1))!=0) res++;
            x = x>>1;
            y = y>>1;
        }
        return res;
    }
}
