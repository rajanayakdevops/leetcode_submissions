class Solution {

    List<List<Integer>> ans;

    public void fun(int index,int[] arr, ArrayList<Integer> curr ){
        if(curr.size() == arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0;i<arr.length;i++){
            if(curr.contains(arr[i])) continue;

            curr.add(arr[i]);
            fun(index+1,arr,curr);
            curr.remove(curr.size()-1);
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        
    ans = new ArrayList<>();

    ArrayList<Integer> curr = new ArrayList<>();
    fun(0,nums,curr);

    return ans;

    }
}