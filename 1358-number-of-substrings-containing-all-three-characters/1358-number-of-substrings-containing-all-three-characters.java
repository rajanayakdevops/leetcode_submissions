// class Solution {
//     public int numberOfSubstrings(String s) {
//         int n = s.length();
//         int right = 0;
//         int left = 0;


//         int count = 0;
//         int[] arr = new int[3];
//         Arrays.fill(arr,-1);

//         while(right < n){
//             char ch = s.charAt(right);

//             arr[ch-'a'] = right;

//             if(arr[0] != -1 && arr[1] != -1 && arr[2] != -1){
                
//                 // this will give me the last occurence right. 
//                int lastIndex = Math.min(arr[0],Math.min(arr[1],arr[2]));
//                count += lastIndex + 1;
               
                  
//             }

//             right++;
//         }

//         return count;

//     }
// }


// class Solution {

//     public int numberOfSubstrings(String s) {

//         int n = s.length();

//         int count = 0;

//         for(int i = 0; i < n; i++) {

//             int[] arr = new int[3];

//             for(int j = i; j < n; j++) {

//                 char ch = s.charAt(j);

//                 arr[ch - 'a']++;

//                 if(arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {

//                     count += (n - j);

//                     break;
//                 }
//             }
//         }

//         return count;
//     }
// }

class Solution {

    public int numberOfSubstrings(String s) {

        int n = s.length();

        int[] freq = new int[3];

        int left = 0;

        int count = 0;

        for(int right = 0; right < n; right++) {

            freq[s.charAt(right) - 'a']++;

            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                count += (n - right);

                freq[s.charAt(left) - 'a']--;

                left++;
            }
        }

        return count;
    }
}