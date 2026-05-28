class Solution {

        int ans = 0;
        int[][] dp;

    public int fun(int i , int j, int count, String str1, String str2 ){
        // base 
        if( i == str1.length() || j == str2.length()){
             
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        // int t = 0;
        if(str1.charAt(i) == str2.charAt(j)){
            return dp[i][j] = 1+ fun(i+1,j+1,count+1,str1,str2);
        }else{
             return dp[i][j] = Math.max(fun(i+1,j,count,str1,str2),
             fun(i,j+1,count,str1,str2));
        }
    }

    public int longestCommonSubsequence(String str1, String str2) {
        
        ans = 0;

        int n = str1.length();
        int m = str2.length();

        dp = new int[n][m];

        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
         return fun(0,0,0,str1,str2);

         

    }
}

