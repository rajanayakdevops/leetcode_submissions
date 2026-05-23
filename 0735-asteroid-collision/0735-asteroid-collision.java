class Solution {
    public int[] asteroidCollision(int[] arr) {
        // valid condition -> st.top moving right and current moving left;
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<arr.length;i++){
            int current = arr[i];
            boolean destoryed = false;  // this will check weather the current is destoryed or not;

            while(!st.isEmpty() && st.peek() > 0 && current < 0 ){  
                if(Math.abs(st.peek()) < Math.abs(current)){
                    st.pop();
                }else if(Math.abs(st.peek()) == Math.abs(current)){
                    destoryed = true;
                    st.pop();
                    break;
                }else{
                    destoryed = true;
                    break;
                }
            }
            if(!destoryed){
                st.push(current);
            }
        
        }

        int[] ans = new int[st.size()];

        for(int i = st.size()-1;i>=0;i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}