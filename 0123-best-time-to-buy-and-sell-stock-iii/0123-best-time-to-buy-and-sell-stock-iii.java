class Solution {

    int[][][] dp;

    public int fun(int index, int buy,int count, int[] arr){
        if(count == 0 || index == arr.length){
            return 0;
        }

        if(dp[index][buy][count] != -1) return dp[index][buy][count];

        int take = 0;
        int notTake = 0;
        if(buy == 0 ){ // buy 
            take = Math.max(-arr[index] + fun(index+1,1,count,arr), 0 + fun(index+1,0,count,arr));
        }else{  // sell 
            notTake = Math.max(arr[index]+fun(index+1,0,count -1, arr),0 + fun(index+1,1,count,arr));
        }

        return dp[index][buy][count] = Math.max(take,notTake);
    }

    public int maxProfit(int[] arr) {

        int n = arr.length;

        dp = new int[n][2][3];

                  for (int i = 0; i < n; i++) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 3; c++) {
                    dp[i][b][c] = -1;
                }
            }
        }
        
        return fun(0,0,2,arr);
    }
}