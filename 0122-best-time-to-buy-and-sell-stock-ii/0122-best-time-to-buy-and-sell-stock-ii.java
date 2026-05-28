class Solution {

    int[][] dp;

    public int fun(int index, int buy, int[] arr){
        if(index == arr.length){
            return 0;
        }

        if(dp[index][buy] != -1) return dp[index][buy];

        int take = 0;
        int notTake = 0;
        if(buy == 0 ){ // buy 
            take = Math.max(-arr[index] + fun(index+1,1,arr), 0 + fun(index+1,0,arr));
        }else{  // sell 
            notTake = Math.max(arr[index]+fun(index+1,0,arr),0 + fun(index+1,1,arr));
        }

        return dp[index][buy] = Math.max(take,notTake);
    }

    public int maxProfit(int[] arr) {

        int n = arr.length;

        dp = new int[n][2];

        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return fun(0,0,arr);
    }
}