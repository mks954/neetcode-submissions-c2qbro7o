class Solution {
    public int[] twoSum(int[] nums, int target) {
        //hashmap
        HashMap<Integer,Integer> mp = new HashMap<>();
        int ans[] = new int[]{};
        int i = 0;
        for(int num: nums){
            mp.put(num,i);
            i++;
        }
        for(int j = 0 ; j < nums.length;j++){
            int diff = target - nums[j];
            if(mp.containsKey(diff) && mp.get(diff)!=j){
                return new int[]{j, mp.get(diff)};
            }
        }
        return new int[0];
    }
}
