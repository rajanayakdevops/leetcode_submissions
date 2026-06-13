class Solution {

    List<List<Integer>> result;

    public void fun(int index, List<Integer> ans , int[] nums){
        // if(index == nums.length){
        //     return;
        // }

        if(ans.size() == nums.length){ 
            result.add(new ArrayList<>(ans));
            return;
            }

        for(int i = 0;i<nums.length;i++){
            if(ans.contains(nums[i])) continue;

            ans.add(nums[i]);
            fun(index+1,ans,nums);
            ans.remove(ans.size()-1);

        }
    }

    public List<List<Integer>> permute(int[] nums) {
        

        result = new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        fun(0,ans, nums);

        return result;

        
    }
}