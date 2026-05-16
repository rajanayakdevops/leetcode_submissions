class Solution {

    public boolean check(int[] arr, int mid, int oper){
        long count = 0;

        for(int i = 0;i<arr.length;i++){
            if(arr[i] > mid){
                if(arr[i] % mid == 0 ){
                    count += (arr[i]/mid)-1;
                }else{
                    count += arr[i]/mid;
                }
            }
        }

        return count <= oper;
    }

    public int minimumSize(int[] arr, int oper) {
        
        int start = 1;

        int end = Integer.MIN_VALUE;

        for(int val : arr){
            start = Math.min(start,val);
            end = Math.max(end,val);
        }
         int ans = 0;

        while(start <= end ){
            int mid = start + (end - start )/2;
           

            if(check(arr,mid,oper)){
                end = mid-1;
                ans = mid;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }
}