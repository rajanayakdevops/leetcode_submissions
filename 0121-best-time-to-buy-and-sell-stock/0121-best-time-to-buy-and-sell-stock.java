class Solution {
    public int maxProfit(int[] arr) {
        
        int n = arr.length;
        int[] pse = new int[n];

        pse[0] = arr[0];

        for(int i = 1;i<n;i++){
            pse[i] = Math.min(arr[i],pse[i-1]);
        }

        int profit = 0;

        for(int i = 1;i<n;i++){
            profit = Math.max(profit,arr[i]-pse[i-1]);
        }

        return profit;
        
    }
}