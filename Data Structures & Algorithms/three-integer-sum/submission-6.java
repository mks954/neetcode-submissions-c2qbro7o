class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num,0)+1);
        }
        for(int i = 0 ; i < n-2 && nums[i]<=0 ; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            count.replace(nums[i], count.get(nums[i])-1);
            for(int j = i+1; j < n-1 ; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                count.replace(nums[j], count.get(nums[j])-1);
                int target = -(nums[i]+nums[j]);
                if(target >= nums[j] && count.containsKey(target) && count.get(target)>0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(target);
                    ans.add(temp);
                }
                count.replace(nums[j], count.get(nums[j])+1);
            }
            count.replace(nums[i], count.get(nums[i]) + 1);
        }
        return ans;
    }
}
