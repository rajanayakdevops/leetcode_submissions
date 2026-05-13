class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){

            int mid = start + (end - start) / 2;

            // boundary check
            if(mid > 0 && mid < arr.length - 1){

                if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                    return mid;
                }

                if(arr[mid] < arr[mid - 1]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            else if(mid == 0){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return -1;
    }
}