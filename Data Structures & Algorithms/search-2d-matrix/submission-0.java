class Solution {
    private int row_no(int num, int col){
        return (num)/col;
    }
    private int col_no(int num, int col){
        return num%col;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m*n-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int i = row_no(mid,n);
            int j = col_no(mid,n);
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j]<target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return false;
    }
}
