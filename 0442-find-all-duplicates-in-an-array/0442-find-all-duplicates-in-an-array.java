class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        // here in this we are making the value at a particular index a negative right. if we see 4 for the first time then we go to index 4-1 and make it negative right and in future if we again see 4 then we again check weather the index 4-1 is positive or negative. this why we can find out weather the number appers twice or not right.... 

        for(int i = 0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;

            if(nums[index] < 0 ){
                ans.add(Math.abs(nums[i]));
            }else{
                nums[index] = -nums[index];
            }
        }

        return ans;
    }
}