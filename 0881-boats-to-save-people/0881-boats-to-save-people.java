import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] nums, int limit) {

        Arrays.sort(nums); // ascending — lightest at left, heaviest at right

        int ptr1 = 0;                   // lightest
        int ptr2 = nums.length - 1;    // heaviest
        int count = 0;

        while (ptr1 <= ptr2) {

            // try to pair the 2 heaviest first
            if (ptr2 - 1 >= ptr1 && nums[ptr2] + nums[ptr2 - 1] <= limit) {
                ptr2--;  // both heavy people fit
                ptr2--;
                count++;

            // else try to pair heaviest with lightest
            } else if (nums[ptr1] + nums[ptr2] <= limit) {
                ptr1++;  // lightest pairs with heaviest
                ptr2--;
                count++;

            // else heaviest goes alone
            } else {
                ptr2--;
                count++;
            }
        }

        return count;
    }
}