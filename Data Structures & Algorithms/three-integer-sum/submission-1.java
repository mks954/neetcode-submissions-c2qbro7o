class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; nums[i] <= 0 && i<n-2 ; i++){
            if( i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = n-1;
            while(j<k){
                if(nums[j]+nums[k]==-nums[i]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                }else if(j>0 && nums[j]==nums[j-1] || nums[j]+nums[k]<-nums[i]){
                    j++;
                }else if(k<0 && nums[k]==nums[k+1] || nums[j]+nums[k]>-nums[i]){
                    k--;
                }
            }
        }
        return ans;
    }
}
