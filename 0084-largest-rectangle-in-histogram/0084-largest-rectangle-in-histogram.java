class Solution {
    public int largestRectangleArea(int[] arr) {

        int n = arr.length;

        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<n;i++){
            int current = arr[i];

            while(!st.isEmpty() && arr[st.peek()] >= current){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1; 
            }else{
                pse[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        for(int i = n-1;i>=0;i--){
            int current = arr[i];

            while(!st.isEmpty() && current <= arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = n;
            }else{
                nse[i] = st.peek();
            }
            st.push(i);
        }


    int ans = 0;

    for(int i = 0;i<n;i++){
        
        int next = nse[i];
        int prev = pse[i];

        int total = ((i - prev) + (next-i))-1;

        ans = Math.max(ans,arr[i]*total);

    }

    return ans;


        
    }
}