class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] dummy = nums.clone();
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        while(j>i){
            if(nums[i]+nums[j]==target){
                break;
            }else if(nums[i]+nums[j]<target){
                i++;
            }else{
                j--;
            }
        } 
        int a = -1;
        int b = -1;
        for(int k = 0 ; k < dummy.length ; k++){
            if(nums[i]==dummy[k] && a == -1){
                a = k;
            }
            else if(nums[j]==dummy[k] && b == -1){
                b = k;
            }
        }
        int[] ans = new int[]{a,b};
        if(a > b){
            return new int[]{b,a};
        }
        return ans;
    }
}
