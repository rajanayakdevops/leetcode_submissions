import java.util.*;

class Solution {
    public static int fun(int[] arr, int target, int index, int[][] dp) {
        // Base case
        if (index == 0) {
            if (target % arr[0] == 0) return target / arr[0];
            return (int)1e9+7;  
        }

        // If already computed
        if (dp[index][target] != -1) return dp[index][target];

        // Take
        int take = Integer.MAX_VALUE;
        if (arr[index] <= target) {
            take = 1 + fun(arr, target - arr[index], index, dp);
        }

        // Not Take
        int notTake = fun(arr, target, index - 1, dp);

        return dp[index][target] = Math.min(take, notTake);
    }

    public int coinChange(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int ans = fun(arr, target, n-1, dp);
        return (ans >= (int)1e9+7) ? -1 : ans;
    }
}
