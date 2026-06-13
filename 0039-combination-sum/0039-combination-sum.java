class Solution {

    List<List<Integer>> result;

    public void fun(int index, int[] arr, int target , List<Integer> ans ){
        
        if(index == arr.length) return;

        if(target == 0 ){
            result.add(new ArrayList<>(ans));
            return;
        }

        if(target-arr[index] >= 0 ){
            ans.add(arr[index]);
            fun(index,arr,target-arr[index],ans);
            ans.remove(ans.size()-1);
        }
        fun(index+1,arr,target,ans);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {

        List<Integer> ans = new ArrayList<>();
        result = new ArrayList<>();

        fun(0,arr,target,ans);


        return result;
        
    }
}