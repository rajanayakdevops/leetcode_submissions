class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

            int n = nums.length;
            int[] par = new int[n];

            for(int i = 0;i<n;i++){
                par[i] = i;
            }

            int[] dp = new int[n];
            Arrays.fill(dp,1);

            Arrays.sort(nums);

            for(int i = 0;i<n;i++){
                for(int j = 0;j<i;j++){
                    if(nums[i] % nums[j] == 0 && dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        par[i] = j;
                    }
                }
            }

            int maxi = -1;
            int index = -1;
            for(int i = 0;i<n;i++){
                if(dp[i] > maxi ){
                    maxi = dp[i];
                    index = i;
                }
            }

            List<Integer> ans = new ArrayList<>();

            while(par[index] != index){
                ans.add(nums[index]);
                index = par[index];
            }
            ans.add(nums[index]);

            return ans;

    }
}