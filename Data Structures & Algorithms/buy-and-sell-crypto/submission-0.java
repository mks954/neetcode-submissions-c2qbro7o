class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 0, j = 0 ; j < prices.length ; j++){
            if(prices[j]<prices[i]){
                i = j;
                continue;
            }else{
                ans = Math.max(prices[j]-prices[i], ans);
            }
        }
        return ans;
    }
}
