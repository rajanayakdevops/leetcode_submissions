class Solution {

    int[][] dp;

    public boolean isValid(String str1 , String str2){

        if(str1.length() != str2.length()+1) return false;

        int ptr1 = 0;
        int ptr2 = 0;

        while(ptr1 < str1.length()){
            if(ptr2 < str2.length() && str1.charAt(ptr1) == str2.charAt(ptr2)){
                ptr1++;
                ptr2++;
            }else{
                ptr1++;
            }
        }

        return ptr2 == str2.length();

    }

    public int fun(int index, int prev, String[] arr){
        if(index == arr.length){
            return 0;
        }

        if(dp[index][prev+1] != -1) return dp[index][prev+1];

        // not pick 
       int not = fun(index+1,prev,arr);

        // pick 
        int pick = 0;
        if(prev == -1 || isValid(arr[index],arr[prev])){
            pick = 1 + fun(index+1,index,arr);
        }

        return dp[index][prev+1] = Math.max(not,pick);
    }

    public int longestStrChain(String[] arr) {

        Arrays.sort(arr,(a,b) -> a.length() - b.length()); 
         
        int n = arr.length;

        dp = new int[n][n+1];

        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return fun(0,-1,arr);

    }
}