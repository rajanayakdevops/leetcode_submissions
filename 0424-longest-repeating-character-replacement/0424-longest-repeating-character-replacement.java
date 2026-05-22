class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];

        int ans = 0;
        
        int right = 0;
        int left = 0;
        int max = 0;


        while(right < s.length()){
            char ch = s.charAt(right);

            arr[ch-'A']++;

            max = Math.max(max,arr[ch-'A']);

            if((right - left + 1) - max > k ){
                // while((right - left + 1) - max > k){
                    char left_char = s.charAt(left);
                    arr[left_char - 'A']--;
                    left++;
                // }
            }

            int current = right - left + 1;

            if((right - left + 1) - max <= k)
            ans = Math.max(ans,current);

            right++;

        }

        return ans;
    }
}