class Solution {
    public int trap(int[] arr) {
        
            int n = arr.length;

            int[] prefix = new int[n];
            int[] suffix = new int[n];

            prefix[0] = arr[0];
            suffix[n-1] = arr[n-1];

            for(int i = 1; i<n;i++){
                prefix[i] = Math.max(arr[i],prefix[i-1]);
            }

            for(int i = n-2;i>=0;i--){
                suffix[i] = Math.max(arr[i],suffix[i+1]);
            }

            int ans = 0;

            for(int i = 1;i<n-1;i++){
                int left_most = prefix[i];
                int right_most = suffix[i];

                int min = Math.min(left_most,right_most);
                
                ans += min - arr[i];

            }

            return ans;
    }


}