class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int ans =0;
        while(l<=r){
            int mid = l + (r-l)/2;
            long total_time = 0;
            for(int p: piles){
                total_time += (long) Math.ceil((double)p/mid);
            }
            if(total_time <= h){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}
