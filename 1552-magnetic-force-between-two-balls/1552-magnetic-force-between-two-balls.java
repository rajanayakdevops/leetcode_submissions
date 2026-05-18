class Solution {

    public boolean check(int mid, int[] arr, int m ){
        int count = 1;
        int prev = 0;

        for(int i = 1;i <arr.length;i++){
            if(Math.abs(arr[i]-arr[prev]) >= mid){
                count++;
                prev = i;
            }
        }

        return count >= m;
    }

    public int maxDistance(int[] arr, int m) {

        Arrays.sort(arr);

        int start = 1;
        int end = arr[arr.length-1] - arr[0];

        int ans = -1;

        while(start <= end){
            int mid = start + (end - start )/2;
            
            if(check(mid,arr,m)){
                ans = mid;
                start = mid +1;
            }else{
                end = mid-1;
            }
        }

        return ans;
        

    }
}