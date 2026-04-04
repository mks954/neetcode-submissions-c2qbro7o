class Solution {
    //using hashset
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        for(int ele:nums){
            numset.add(ele);
        }
        if(numset.size() != nums.length) return true;
        return false;
    }
}