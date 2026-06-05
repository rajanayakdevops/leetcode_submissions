class Solution {

    int[] dp;

    public int fun(int n ){
        if(n == 0 ) return 0;
        if(n == 1 ) return 1;


        if(dp[n] != -1) return dp[n];

        return dp[n] =  fun(n-1) + fun(n-2);
    }

    public int fib(int n) {

        if( n == 0 ) return 0; 
        if(n == 1 ) return 1;


        dp = new int[n+1];

        Arrays.fill(dp,-1);
        


        return fun(n);
    }
}