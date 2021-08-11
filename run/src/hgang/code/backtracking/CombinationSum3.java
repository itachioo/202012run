package hgang.code.backtracking;

import java.util.ArrayList;
import java.util.List;


//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
// 说明：
//
//
// 所有数字都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
//
//
// 示例 2:
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//
// Related Topics 数组 回溯
// 👍 327 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class CombinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        process(k,n,0, 1);
        return res;
    }

    public void process(int k, int n, int sum, int index) {
        if (path.size()==k) {
            if (sum==n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i=index;i<=9;i++) {
            path.add(i);
            sum += i;
            process(k,n,sum,i+1);
            path.remove(path.size()-1);
            sum -= i;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
