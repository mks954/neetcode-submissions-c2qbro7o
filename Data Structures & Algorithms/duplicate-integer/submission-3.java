class Solution {
    //using hashset
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        for(int ele:nums){
            if(numset.contains(ele)==true) return true;
            numset.add(ele);
        }
        return false;
    }
}