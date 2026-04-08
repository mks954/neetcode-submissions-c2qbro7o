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
        for(Map.Entry<Integer,Integer>e:mp.entrySet()){
            if(mp.containsKey(target - e.getKey())){
                int a = mp.get(target - e.getKey());
                if(e.getValue()>a){
                    ans = new int[]{a, e.getValue()};
                }
                else{
                    ans = new int[]{e.getValue(), a};
                }
            }
        }
        return ans;
    }
}
