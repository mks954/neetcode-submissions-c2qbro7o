class Solution {
    private int pivot_index(int[] nums){
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    private int binary_search(int[] nums, int l, int r, int target){
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int pivot = pivot_index(nums);

        if(target >= nums[pivot] && target <= nums[nums.length - 1]){
            return binary_search(nums, pivot, nums.length - 1, target);
        } else {
            return binary_search(nums, 0, pivot - 1, target);
        }
    }
}