class Solution {


    public boolean check(int mid,int[]arr, int m, int k){
        int count = 0;
        int temp = 0;

        for(int i = 0;i<arr.length;i++){
            if(arr[i] <= mid){
                temp++;
            }else{
                temp = 0;
            }

            if(temp == k){
                count++;
                temp = 0;
            }
        }

        return count >= m;
    }

    public int minDays(int[] arr, int m, int k) {
        int start = Integer.MAX_VALUE;
        int end = -1;


        for(int a : arr){
            end = Math.max(end,a);
            start = Math.min(start,a);
        }
        int ans = -1;

        while( start <= end ){
            int mid = start + (end - start)/2;

            if(check(mid,arr,m,k)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }
}