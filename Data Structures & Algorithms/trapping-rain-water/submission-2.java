class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        for(int i = 0 ; i < height.length ; i++){
            int l_wall = 0;
            int r_wall = 0;
            if(i>0){
                for(int j = i-1; j >= 0; j--){
                    l_wall = Math.max(l_wall, height[j]);
                }
            }   
            if(i<n-1){
                for(int j = i+1; j < n; j++){
                    r_wall = Math.max(r_wall, height[j]);
                }
            }
            int temp = Math.min(l_wall,r_wall)-height[i];
            if(temp>0){
                ans += temp;
            }
        }
        return ans;
    }
}
