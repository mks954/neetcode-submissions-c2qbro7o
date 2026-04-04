class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j < n ; j++){
                int temp = Math.min(heights[i], heights[j])*(j-i);
                ans=Math.max(temp, ans);
            }
        }
        return ans;
    }
}
