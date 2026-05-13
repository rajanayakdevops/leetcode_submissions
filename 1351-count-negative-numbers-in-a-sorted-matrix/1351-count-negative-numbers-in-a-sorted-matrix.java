class Solution {
    public int countNegatives(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int i = n-1;
        int j = 0;

        int count = 0;


        while( i >= 0 && j <m){
            if(arr[i][j] < 0 ){
                int range = m-j;
                count += range;

                i--;
            }else{
                j++;
                
            }
        }

        return count;
    }
}