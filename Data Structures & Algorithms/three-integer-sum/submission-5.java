class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num,0)+1);
        }
        for(int i = 0 ; i < n-1 ; i++){
            count.replace(nums[i], count.get(nums[i])-1);
            for(int j = i+1; j < n ; j++){
                count.replace(nums[j], count.get(nums[j])-1);
                int target = -(nums[i]+nums[j]);
                if(count.containsKey(target) && count.get(target)>0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(target);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}
