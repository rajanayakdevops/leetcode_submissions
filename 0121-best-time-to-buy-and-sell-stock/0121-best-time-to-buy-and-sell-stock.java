class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        int n = prices.length;
        int[] prefix = new int[n];
        prefix[0] = prices[0];
        for(int i =1;i<n;i++){
            prefix[i] = Math.min(prefix[i-1],prices[i]);
        }

        for(int i = 1;i<n;i++){
            profit = Math.max(profit,prices[i]-prefix[i-1]);
        }

        return profit;
    }
}