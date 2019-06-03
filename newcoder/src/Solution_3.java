import org.junit.jupiter.api.Test;

public class Solution_3 {
    /**
     * 题目：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy.
     * 思路一：暴力替换，时间复杂度O(N*N)，由于直接插入导致其后面的字符全部后移两个位置，
     *         插入一个元素代价O(N),对于含有O(N)个空格的字符串，时间复杂度O(N)
     */
    public String replaceSpace(StringBuffer str) {
        /**
         * 思路一：暴力替换，时间复杂度O(N*N)，由于直接插入导致其后面的字符全部后移两个位置，
         *        插入一个元素代价O(N),对于含有O(N)个空格的字符串，时间复杂度O(N)
         */
        for(int i=0; i<str.length();i++) {
            if(str.charAt(i)==' ') {
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }

    public String replaceSpace1(StringBuffer str) {
        /**
         * 思路二：先计算出空格的数量，重新设置StringBuffer容量，两个指针，一个指向原始容量末尾，一个指向新容量末尾，
         * 遇到空格则加入三个字符%20，否则，复制元素，没有使用额外空间，且时间复杂度O(N)
         */
        int len = str.length();
        int spaceNum = 0;
        for(int i=0;i<len;i++) {
            if (str.charAt(i) == ' ') {
                spaceNum ++;
            }
        }
        str.setLength(len+spaceNum*2);
        int oldStr = len-1;
        int newStr = str.length()-1;
        while(oldStr>=0) {
            if(str.charAt(oldStr)==' ') {
                str.setCharAt(newStr--, '0');
                str.setCharAt(newStr--, '2');
                str.setCharAt(newStr--, '%');
            }
            else {
                str.setCharAt(newStr--,str.charAt(oldStr));
            }
            oldStr--;
        }
        return str.toString();
    }

    @Test
    public void test() {
        System.out.println(replaceSpace1(new StringBuffer(" hello world ")));
    }
}
