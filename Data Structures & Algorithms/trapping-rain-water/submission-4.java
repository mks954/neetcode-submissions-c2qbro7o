class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length -1;
        int l_wall = height[left];
        int r_wall = height[right];
        int ans = 0;
        while(left<right){
            if(l_wall<r_wall){
                left++;
                if(height[left]<l_wall){
                    ans+=l_wall-height[left];
                }
                l_wall = Math.max(height[left],l_wall);
            }else{
                right--;
                if(height[right]<r_wall){
                    ans+=r_wall-height[right];
                }
                r_wall = Math.max(height[right], r_wall);
            }
        }
        return ans;
    }
}
