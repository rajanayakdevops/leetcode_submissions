class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;


        int left = 0;
        int right = 0;

        int sum = 0;

        while(right < nums.length ){
            sum += nums[right];

            

            if(sum >= target){  
                int range = right - left + 1;
                ans = Math.min(ans,range);
        
                while(sum >= target ){
                    sum -= nums[left];

                 range = right - left + 1;
                ans = Math.min(ans,range);

                    left++;
                }

            }

            right++;

        }
        if(ans == Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}