import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people); // sort ascending
        
        int ptr1 = 0;                    
        int ptr2 = people.length - 1;   
        int count = 0;

        while (ptr1 <= ptr2) {
            if (people[ptr1] + people[ptr2] <= limit) {
                ptr1++;            
                 }
            ptr2--;
            count++;
        }

        return count;
    }
}