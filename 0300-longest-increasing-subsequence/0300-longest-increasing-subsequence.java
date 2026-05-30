class Solution {
    public int lengthOfLIS(int[] arr) {

    int n = arr.length;
    
    int[] dp = new int[n];

    Arrays.fill(dp,1);


    for(int i = 0;i<n;i++){
        for(int j = 0;j<i;j++){
            if(arr[i] > arr[j] && dp[j]+1 > dp[i]){
                dp[i] = dp[j]+1;
            }
        }
    }

    int ans = -1;

    for(int val : dp){
        if(val > ans) ans = val;
    }

    return ans;
        
    }
}