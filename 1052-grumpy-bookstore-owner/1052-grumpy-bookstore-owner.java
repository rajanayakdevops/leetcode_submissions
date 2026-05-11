class Solution {
    public int maxSatisfied(int[] com, int[] gru, int min) {
        
        int start = 0;
        
        int max = 0;
        int m = gru.length;

        
        for(int i = 0;i<min;i++){
            if(gru[i] == 0)
            max += com[i];
        }   
        
        int left = 0;
        int right = min;

        int curr = max;


        while(right < m){
            if (gru[right] == 1) {
                curr += com[right];
            }

            if (gru[left] == 1) {
                curr -= com[left];
            }

            if(curr > max){
                max = curr;
                start = left+1;
            }

            left++;
            right++;


        }

        int s = start;
        int e = start+min;


        int ans = 0;

        for(int i = 0;i<com.length;i++){
            if(i >= s && i < e){
                ans += com[i];
            }else if(gru[i] == 0){
                ans += com[i];
            }
        }

            return ans;
    }
}