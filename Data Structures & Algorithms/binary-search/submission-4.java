class Solution {
    public int search(int[] nums, int target) {
        int l = -1;
        int r = nums.length;   // FIXED

        while (l + 1 < r) {    // FIXED condition
            int mid = l + (r - l) / 2;

            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        // r is the first index >= target
        if (r == nums.length) return -1;
        return nums[r] == target ? r : -1;
    }
}