class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] l_wall = new int[n];
        int[] r_wall = new int[n];
        l_wall[0] = 0;
        r_wall[n-1] = 0;
        
        for(int i = 1, j = n-2 ; i < n ; i++){
            l_wall[i] = Math.max(l_wall[i-1], height[i-1]);
            r_wall[j] = Math.max(r_wall[j+1], height[j+1]);
            j--;
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int temp = Math.min(l_wall[i], r_wall[i]) - height[i];
            if(temp>0){
                ans+=temp;
            }
        }
        return ans;

    }
}
