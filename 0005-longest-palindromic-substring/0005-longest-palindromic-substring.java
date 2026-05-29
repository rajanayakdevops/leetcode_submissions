class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;


        for(int i = 0;i<s.length();i++){
            int left = i;
            int right = i;


    // this is for odd number right and for this we are both then pointer start from same index right

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ){
                if(right - left + 1 > max ){
                    max = right - left + 1;
                    ans = s.substring(left,right+1);
                }
                left--;
                right++;
            }

    // this is for even number of string 
            left = i;
            right = i+1;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ){
                if(right - left + 1 > max ){
                    max = right - left + 1;
                    ans = s.substring(left,right+1);
                }
                left--;
                right++;
            }

        }

        return ans;
    }
}