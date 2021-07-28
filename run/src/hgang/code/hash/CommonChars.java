package hgang.code.hash;
import java.util.ArrayList;
import java.util.List;


//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
//
//
// 示例 2：
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 100
// 1 <= A[i].length <= 100
// A[i][j] 是小写字母
//
// Related Topics 数组 哈希表 字符串
// 👍 230 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class CommonChars {
    public static List<String> commonChars(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        int[] map = new int[26];
        for (int i=0;i<words[0].length();i++) {
            map[words[0].charAt(i)-'a']++;
        }
        for (int i=1;i<words.length;i++) {
            int[] map1 = new int[26];
            for (int j=0;j<words[i].length();j++) {
                map1[words[i].charAt(j)-'a']++;
            }
            for (int k=0;k<26;k++) {
                map[k] = Math.min(map[k],map1[k]);
            }
        }
        for (int i=0;i<26;i++) {
            while (map[i]!=0) {
                res.add(String.valueOf(Character.toChars('a'+i)));
                map[i]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s = {"bella","label","roller"};
        System.out.println(commonChars(s));
    }
}

//leetcode submit region end(Prohibit modification and deletion)
