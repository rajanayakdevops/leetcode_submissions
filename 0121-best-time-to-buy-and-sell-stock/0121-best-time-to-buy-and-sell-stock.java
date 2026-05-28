class Solution {
    public int maxProfit(int[] arr) {
        
        int n = arr.length;
        int[] previous_smaller_element = new int[n];

        // the profit of selling the stock at index i will be => arr[i] - smallest value from range ( 0, i-1);


        previous_smaller_element[0] = arr[0];

        for(int i = 1;i<n;i++){
            previous_smaller_element[i] = Math.min(arr[i],previous_smaller_element[i-1]);
        }

        int profit = 0;

        for(int i = 1;i<n;i++){
            profit = Math.max(profit,arr[i]-previous_smaller_element[i-1]);
        }

        return profit;
        
    }
}