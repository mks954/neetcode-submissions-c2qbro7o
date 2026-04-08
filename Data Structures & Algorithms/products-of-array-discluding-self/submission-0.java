class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroes = 0;
        
        for(int num:nums){
            if(num==0){
                zeroes++;
            }
        }
        int n = nums.length;
        int[] ans = new int[n];
        if(zeroes==1){
            int zero_loc = 0;
            int prod = 1;
            for(int i = 0 ; i < n ; i++){
                if(nums[i]==0){
                    zero_loc = i;
                }else{
                    prod *= nums[i];
                }
            }
            ans[zero_loc]= prod;
        }else{
            int prod = 1;
            for(int i = 0 ; i < n ; i++){
                prod *= nums[i];
            }
            for(int i = 0 ; i < n ; i++){
                ans[i] = prod/nums[i];
            }
        }
        return ans;
    }
}  
