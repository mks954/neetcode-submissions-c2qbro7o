class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int minb = prices[0];
        for(int sell:prices){
            maxp = Math.max(maxp, sell - minb);
            minb = Math.min(minb, sell);
        }
        return maxp;
    }
}
