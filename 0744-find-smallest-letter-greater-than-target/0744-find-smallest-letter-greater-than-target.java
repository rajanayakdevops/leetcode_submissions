class Solution {
    public char nextGreatestLetter(char[] letter, char target) {

            int start = 0;
            int end = letter.length-1;

            int index = 0;

            while(start <= end){
                int mid = start + (end-start)/2;

                if(letter[mid]-'a' > target-'a'){
                        index = mid;
                        end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            

            return letter[index];
    }
}