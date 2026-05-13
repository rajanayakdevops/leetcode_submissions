class Solution {
    public boolean isPerfectSquare(int num) {

        if(num == 1) return true;

        int start = 1;
        int end = num / 2;

        while(start <= end){

            int mid = start + (end - start) / 2;

            long prod = (long) mid * mid;

            if(prod == num){
                return true;
            }

            if(prod > num){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}