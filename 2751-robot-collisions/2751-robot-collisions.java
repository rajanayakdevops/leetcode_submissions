class pair{
    int index;
    char ch;

    pair(int index, char ch){
        this.index = index;
        this.ch = ch;
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] arr, int[] health, String dir) {
        

    Stack<pair> st = new Stack<>();
    int n = arr.length;
// supoose we have sorted right. Writing the logic after that.

    Integer[] order = new Integer[n];
    for(int i = 0;i<n;i++){
        order[i] = i;
    }

    Arrays.sort(order,(a,b)-> arr[a] - arr[b]);

    for(int j = 0;j<n;j++){
        int i = order[j];
        int current_health = health[i];
        char current_dir = dir.charAt(i);

        boolean destroyed = false;


        while(!st.isEmpty() && (current_dir == 'L' && st.peek().ch == 'R')){
            if(health[i] > health[st.peek().index]){
                health[st.peek().index] = -1;
                health[i]--;
                st.pop();

            }else if( health[i] == health[st.peek().index]){
                health[i] = -1;
                health[st.peek().index] = -1;
                destroyed = true;
                st.pop();
                break;

            }else{
                health[st.peek().index]--;
                health[i] = -1;
                destroyed = true;
                break;
            }
        }
        if(!destroyed ) st.push(new pair(i,dir.charAt(i)));

    }

    List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(health[i] != -1){
                ans.add(health[i]);
            }
        }

return ans;


    }
}