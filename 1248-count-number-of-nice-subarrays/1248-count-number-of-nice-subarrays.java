class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // assuming odd numbers to be 1 right and even number as 0 right.
        // can be reframed as Count the number of subarrays whose sum = k

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        
        int count = 0;
        int n = nums.length;
        int current_sum = 0;

        for(int i = 0;i<n;i++){
            if(nums[i] % 2 != 0 ){
                current_sum += 1;
            }

            if(map.containsKey(current_sum - k )){
                count += map.get(current_sum - k);
            }

            map.put(current_sum, map.getOrDefault(current_sum,0) + 1);



        }
        
        return count;
        
    }
}