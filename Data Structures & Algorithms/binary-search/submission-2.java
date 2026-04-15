class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid]<=target){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        if(l==0) return -1;
        return nums[l-1]==target ? l-1:-1;
    }
}
