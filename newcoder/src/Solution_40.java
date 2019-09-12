import org.junit.jupiter.api.Test;
public class Solution_40 {
    /**
     * leetcode 6
     */
    public String convert(String s, int numRows) {
        String[] str = new String[numRows];
        for(int i=0;i<numRows;i++) {
            str[i] = "";
        }
        if(numRows==1) return s;
        int len = s.length();
        int i=0;
        boolean isDown = false;
        for(int j=0;j<len;j++) {
            //if(i==0) isDown = true;
            //if(i==numRows-1) isDown = false;
            //！ 简化代码
            if(i==0||i==numRows-1) isDown = !isDown;
            str[i] = str[i] + String.valueOf(s.charAt(j));
//            if(isDown) {
//                i++;
//            }
//            else {
//                i--;
//            }
            // 三目运算符简化代码
           i +=  (isDown==true) ? 1: -1;
        }
        String res = "";
        for(String s1: str) {
            res += s1;
        }
        return res;
    }

    @Test
    public void test(){
        convert("AB",1);

    }
}
