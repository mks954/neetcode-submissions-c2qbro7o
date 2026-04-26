class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] count = new int[n+1];
        for(int i = 0 ; i < nums.length ; i++){
            if(count[nums[i]]>0){
                return nums[i];
            }
            count[nums[i]] += 1;
        }
        return -1;
    }
}
