class Solution {
    public String mostCommonWord(String para, String[] banned) {
        
        para = para.toLowerCase();

        int n = para.length();
        para = para.replaceAll("[^a-z]"," ");

        HashSet<String> set = new HashSet<>();

        String[] arr = para.split(" ");

        for(String str : banned){
            set.add(str);
        }

        HashMap<String, Integer> map = new HashMap<>();

        String ans = "";
        int maxFreq = 0;

        for (String word : arr) {

            if (word.length() == 0 || set.contains(word))
                continue;

            map.put(word, map.getOrDefault(word, 0) + 1);

            if (map.get(word) > maxFreq) {
                maxFreq = map.get(word);
                ans = word;
            }
        }


        return ans;

    }
}