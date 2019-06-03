public class Solution_1 {
    public static boolean Find(int target, int [][] array) {
        int rowNum = array.length;
        int colNum = array[0].length;
        int tarRow = TwoFindRow(0, rowNum-1, array, target);
        if(tarRow == -1) return false;
        int tarCol = TwoFindCol(0, colNum-1, array[tarRow], target);
        if (tarCol == -1) return false;
        return true;

    }

    public static int TwoFindRow(int start, int end, int[][] array, int target) {
        if (start == end) {
            if (target == array[start][0]) return start;
            else return -1;
        }
        int mid = (start + end) /2;
        if(array[mid][0]> target) return TwoFindRow(start, mid,array, target);
        else if(array[mid][0] == target) return mid;
        else return TwoFindRow(mid+1,end,array,target);
    }

    public static int TwoFindCol(int start, int end, int[] array, int target) {
        if (start == end) {
            if (target == array[start]) return start;
            else return -1;
        }
        int mid = (start + end) /2;
        if(array[mid]> target) return TwoFindCol(start, mid,array, target);
        else if(array[mid] == target) return mid;
        else return TwoFindCol(mid+1,end,array,target);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(9, arr));
    }
}