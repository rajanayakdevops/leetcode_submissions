class Solution {
    public String pushDominoes(String a) {

        int n = a.length();
        int[] right = new int[n];
        int[] left = new int[n];

        int force = 0;

        for (int i = 0; i < n; i++) {

            if (a.charAt(i) == 'R') {
                force = n;
            } 
            else if (a.charAt(i) == 'L') {
                force = 0;
            } 
            else {
                force = Math.max(force - 1, 0);
            }

            right[i] = force;
        }

        force = 0;

        for (int i = n - 1; i >= 0; i--) {

            if (a.charAt(i) == 'L') {
                force = n;
            } 
            else if (a.charAt(i) == 'R') {
                force = 0;
            } 
            else {
                force = Math.max(force - 1, 0);
            }

            left[i] = force;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {

            if (right[i] == left[i]) {
                ans.append('.');
            } 
            else if (right[i] > left[i]) {
                ans.append('R');
            } 
            else {
                ans.append('L');
            }
        }

        return ans.toString();
    }
}