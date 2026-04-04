class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] r_wall = new int[n];
        int[] l_wall = new int[n];
        l_wall[0] = 0;
        r_wall[n-1] = 0;
        int rindex = n-2;
        for(int l_index = 1 ; l_index < n ; l_index++){
            l_wall[l_index] = Math.max(l_wall[l_index-1], height[l_index-1]);
            r_wall[rindex] = Math.max(r_wall[rindex+1], height[rindex+1]);
            rindex--;
        }
        int ans = 0;
        for(int i = 0; i < n ; i++){
            int temp = Math.min(l_wall[i], r_wall[i]) - height[i];
            if(temp>=0){
                ans += temp;   
            }
        }
        return ans;
    }
}
