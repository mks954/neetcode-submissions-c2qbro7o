class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int r = rows-1;

        // find rows
        int ans_row = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(matrix[mid][0]<= target && matrix[mid][cols-1]>=target){
                ans_row = mid;
                break;
            }else if(matrix[mid][cols-1]<target){
                l = mid+1;
            }else if(matrix[mid][0]>target){
                r = mid-1;
            }
        }

        if(ans_row==-1) return false;
        //find cols
        l=0;
        r=cols-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(matrix[ans_row][mid]==target){
                return true;
            }else if(matrix[ans_row][mid]<target){
                l=mid+1;
            }else if(matrix[ans_row][mid]>target){
                r=mid-1;
            }
        }

        return false;   
    }
}
