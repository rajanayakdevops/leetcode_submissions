class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;

        int right = 0;
        int left = 0;

        long prod = 1;
        long sum = 0;


        while(right < nums.length){
            sum += nums[right];

            long range = right - left + 1;

            // if(sum * range >= k ){
                while(sum * range >= (long)k){
                     sum -= nums[left];
                    left++;
                   
                    range = right - left + 1;
                }
            // }

            ans += right - left + 1;
            right++;

        }

        return ans;
    }
}