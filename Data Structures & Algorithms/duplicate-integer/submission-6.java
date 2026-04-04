class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int m: nums) numbers.add(m);
        if(numbers.size()!=nums.length) return true;
        return false;
    }
}