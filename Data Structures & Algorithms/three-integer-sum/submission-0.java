class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n-2 ; i++){
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l = i+1, r =  n-1;
            while(l<r){
                int threesum = nums[i] + nums[l] + nums[r];
                if(threesum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }else if(threesum<0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }
}
