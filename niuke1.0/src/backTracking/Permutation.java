package backTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        permute(arr);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        res = process(res, nums, path, used);
        System.out.println(res);
        return res;
    }

    public static List<List<Integer>> process(List<List<Integer>> res, int[] nums, List<Integer> path, boolean[] used) {
        if(path.size()>=nums.length) {
            res.add(new ArrayList<>(path));
            return res;
        }
        for (int i=0;i<nums.length;i++) {
            if(used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            process(res,nums,path,used);
            path.remove(path.size()-1);
            used[i] = false;
        }
        return res;

    }


}