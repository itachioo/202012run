package hgang.code;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明：
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例：
//
//
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6]
//
//
//
// 提示：
//
//
// -10^9 <= nums1[i], nums2[i] <= 10^9
// nums1.length == m + n
// nums2.length == n
//
// Related Topics 数组 双指针
// 👍 718 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

public class Merge{
    public static void main(String[] args) {
        mergeSolution solution = new mergeSolution();
        System.out.println();
    }

}

class mergeSolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 思路1：用nums2的数依次与nums1对比，比nums1小的话需要把nums2的当前元素移入nums1该位置，此时nums1需要大动干戈所有元素往后移动
        // 一个位置，有点傻叉
        // 思路2：可以直接合并两个数组，再排序
        int index = 0;
        for (int i=0;i<n;i++) {
            for (int j=index;j<m;j++) {
                if (nums2[i]<=nums1[j]) {
                    int temp = nums1[j];
                    nums1[j] = nums2[i];
                }
            }
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 思路3：用额外的空间m，先把nums1复制，用指针p1、p2分别指向copynums1、nums2，然后比较指针指向的值，小的直接放到nums1中
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1,0,nums1Copy,0,m);
        int p1=0;
        int p2=0;
        int p=0;
        while(p1<m&&p2<n) {
            nums1[p++] = nums1Copy[p1]<nums2[p2] ? nums1Copy[p1++]:nums2[p2++];
        }
        //注意判断两个数组没遍历完的情况，没遍历完的数组直接copy到nums1末尾就好了
        if (p1<m) {
            System.arraycopy(nums1Copy,p1,nums1,p1+p2,m+n-p1-p2);
        }
        if(p2<n) {
            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
