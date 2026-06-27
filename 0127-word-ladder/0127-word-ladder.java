
// class pair {
//     String str;
//     int count;

//     pair(String str, int count){
//         this.str = str;
//         this.count = count;
//     }
// }

// class Solution {

//     public boolean isValid(String str1, String str2){
        
//         int count = 0;

//         for(int i = 0;i<str1.length();i++){
//             if(str1.charAt(i) != str2.charAt(i)){
//                 count++;
//             }
//         }

//         return count == 1;

//     }
//     public int ladderLength(String start, String end , List<String> dic) {
//         // this apprach is also used in graph right.
         
//          int n = dic.size();

//         boolean[] visited = new boolean[n];

//         Queue<pair> q = new LinkedList<>();

//         q.offer(new pair(start,1));

//         while(!q.isEmpty()){
//             String str = q.peek().str;
//             int count = q.peek().count;

//             q.poll();

//             if(str.equals(end)) return count;

//             for(int i = 0;i<n;i++){
//                 if(!visited[i]){

                   
                    
//                     if(isValid(str,dic.get(i))){
//                          visited[i] = true;
//                         q.offer(new pair(dic.get(i),count+1));
//                     }

//                 }
//             }
//         }

//         return 0;

        
//     }
// }


// // More optimised aproahc the above code time complexity is O(N2 * L );
// // but  the code below using HashSet + BFS + Character Transformation tc - O(N * L );  Here in this code we try possibility by changing each character of the start word with all 26 character but only index at a time and then we checkk weather that number present inside the hashset or not right.. 

// class Pair {
//     String word;
//     int level;

//     Pair(String word, int level) {
//         this.word = word;
//         this.level = level;
//     }
// }

// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {

//         HashSet<String> set = new HashSet<>(wordList);

//         if (!set.contains(endWord)) {
//             return 0;
//         }

//         Queue<Pair> q = new LinkedList<>();
//         q.offer(new Pair(beginWord, 1));

//         set.remove(beginWord);

//         while (!q.isEmpty()) {

//             Pair curr = q.poll();
//             String word = curr.word;
//             int level = curr.level;

//             if (word.equals(endWord)) {
//                 return level;
//             }

//             char[] arr = word.toCharArray();

//             for (int i = 0; i < arr.length; i++) {

//                 char original = arr[i];

//                 for (char ch = 'a'; ch <= 'z'; ch++) {

//                     arr[i] = ch;
//                     String newWord = new String(arr);

//                     if (set.contains(newWord)) {
//                         q.offer(new Pair(newWord, level + 1));
//                         set.remove(newWord);
//                     }
//                 }

//                 arr[i] = original;
//             }
//         }

//         return 0;
//     }
// }


// another optimised code comparend to first code. The time complexity of the secod and the third code is same right.. 

// Instead of searching only from beginWord, we search simultaneously from:

// beginWord
// endWord

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return 0;
        }

        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int level = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            // Always expand the smaller side
            // here we are checking which set contains lesser number of words because in further code we are going to explain list right and expanding longer list will cost more time right. so we prefer to expand the list containing lesser number of words...
            if (beginSet.size() > endSet.size()) {
                HashSet<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }


// this nextlevel list is to store the new or updated words righ... 
            HashSet<String> nextLevel = new HashSet<>();

// remember that at this point the beginSet will always consist lesser number of words because we did swapping before right and stored the result inside the begin set right.... 

            for (String word : beginSet) {

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[i] = ch;
                        String newWord = new String(arr);

                        if (endSet.contains(newWord)) {
                            return level + 1;
                        }

                        if (dict.contains(newWord)) {
                            nextLevel.add(newWord);
                            dict.remove(newWord);
                        }
                    }

                    arr[i] = original;
                }
            }

            beginSet = nextLevel;
            level++;
        }

        return 0;
    }
}

