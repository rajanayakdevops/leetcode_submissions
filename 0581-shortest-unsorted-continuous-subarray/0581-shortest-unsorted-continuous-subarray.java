class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int max = nums[0];
        int min = nums[nums.length - 1];

        boolean left = false;
        boolean right = false;

        int ptr1 = 1;
        int ptr2 = nums.length - 2;

        int leftBoundary = -1;   // store the actual boundary
        int rightBoundary = -1;

        while (ptr1 < nums.length || ptr2 >= 0) {

            // left pass — keep updating boundary even after left==true
            if (ptr1 < nums.length) {
                if (nums[ptr1] < max) {
                    left = true;
                    leftBoundary = ptr1;  // keep updating to get RIGHTMOST break
                } else {
                    max = nums[ptr1];
                }
                ptr1++;
            }

            // right pass — keep updating boundary even after right==true
            if (ptr2 >= 0) {
                if (nums[ptr2] > min) {
                    right = true;
                    rightBoundary = ptr2; // keep updating to get LEFTMOST break
                } else {
                    min = nums[ptr2];
                }
                ptr2--;
            }
        }

        if (!left && !right) return 0;

        return leftBoundary - rightBoundary + 1;
    }
}