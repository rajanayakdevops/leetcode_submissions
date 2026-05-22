class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0;
        int right = 0;


        HashMap<Character,Integer> map = new HashMap<>();

        int n = s.length();

        for(right = 0;right <n;right++){

            char ch = s.charAt(right);

            if(map.containsKey(ch)){
                int index = map.get(ch);
                if(index >= left){
                    left = index+1;
                }
            }

            int current = right - left + 1;
            map.put(ch,right);

            ans = Math.max(ans,current);

        }

        return ans;
    }
}