class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        // O(n) -> TC and O(1) -> space complexity
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }
}