class Solution {
    public int[] findOrder(int n, int[][] arr) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }        
        int[] inorder = new int[n];

        for(int[] val : arr){
            int u = val[0];
            int v = val[1];

            adj.get(u).add(v);
            inorder[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<n;i++){
            if(inorder[i] == 0 ) q.offer(i);
        }

        Stack<Integer> st = new Stack<>();
        
        int count = 0 ;


        while(!q.isEmpty()){
            int current = q.poll();
            st.push(current);
            count++;
            for(int neigh : adj.get(current)){
                inorder[neigh]--;

                if(inorder[neigh] == 0 ) q.offer(neigh);
            }

        }
    
        if(count != n ) return new int[]{};

        int m = st.size();
        int[] ans = new int[m];


        int index = 0;
        while(!st.isEmpty()){
            ans[index++] = st.pop();
        }

        return ans;

    }
}