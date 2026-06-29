class Solution {
    public boolean canFinish(int n, int[][] arr) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());

        }
        
        int[] inorder = new int[n];

        for(int[] val : arr ){
            int u = val[0];
            int v = val[1];

            adj.get(u).add(v);
            inorder[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<n;i++){
            if(inorder[i] == 0 ) q.offer(i);
        }

        int count = 0;

        while(!q.isEmpty()){
            int current = q.poll();
            count++;

            for(int val: adj.get(current)){
                inorder[val]--;
                if(inorder[val] == 0 ) q.offer(val);
            }
        }

        return count == n;
        
    }
}