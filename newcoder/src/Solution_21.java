import org.junit.jupiter.api.Test;

public class Solution_21 {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0) return false;
        return process(sequence, 0,sequence.length-1);
    }

    public boolean process(int[] arr, int start, int end) {
        if(start>=end) return true;
        int root = arr[end];
        int index = start;
        for(;index<end;index++) {
            if(arr[index]>root) break;
        }
        for (int i=index;i<end;i++) {
            if(arr[i]<root) return false;
        }
        return process(arr, start,index-1)&& process(arr,index,end-1);

    }

    @Test
    public void test(){
        int[] arr = {7,4,6,5};
        System.out.println(VerifySquenceOfBST(arr));
    }



}
