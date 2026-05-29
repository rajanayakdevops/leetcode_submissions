class Solution {

    int[][] dp;

    public int fun(int i, int j , String s1, String s2 ){
        // base 
        if(i < 0 || j < 0 ){
            return 0;
        }

        if(dp[i][j] != -1 ) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] =  1 + fun(i- 1, j - 1, s1,s2);
        }else{
            return dp[i][j] =  Math.max(fun(i-1,j,s1,s2), fun(i,j-1,s1,s2));
        }
    }

    public int longestPalindromeSubseq(String s) {

        String s2 = new StringBuilder(s).reverse().toString();
        int n = s.length();

        dp = new int[n][n];

        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }


        return fun(n-1,n-1,s,s2);
        
    }
}