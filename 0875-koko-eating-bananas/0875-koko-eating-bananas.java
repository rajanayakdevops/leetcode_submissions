class Solution {

    public boolean check(int[] arr, int mid , int h ){
        long hours = 0;



        for(int i = 0;i<arr.length;i++){
            if(arr[i]<= mid){
                hours++;
            }else{
                hours += (int)Math.ceil((double)arr[i]/mid);
            }

            // System.out.println(mid +" "+ (int)Math.ceil(arr[i]/mid) + " "+ hours);
        }

        return hours <= h;

        

    }
    public int minEatingSpeed(int[] arr, int h) {
        
        int min = 1;
        int max = Integer.MIN_VALUE;

        for(int val : arr){
            //  min = Math.min(min,val);
             max = Math.max(max,val);
        }

        int start = min;
        int end = max;

        int ans = -1;

        while(start <= end ){
            int mid = start + (end - start)/2;


            if(check(arr,mid,h)){
                end = mid-1;
                ans = mid;
            }else{
                start = mid+1;
            }
        }


        return ans;

    }
}