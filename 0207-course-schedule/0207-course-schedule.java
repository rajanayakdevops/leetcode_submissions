class Solution {
    public boolean canFinish(int n, int[][] arr) {

        // this is one of the main takeaway from khans algo -> The count tells us how many vertices Kahn's algorithm successfully removed.

// count == n → Every node was removed → No cycle → All courses can be finished ✅

// Remember that this can be asked in future rigth....... 
// count < n → Some nodes could not be removed → Those nodes are trapped in a cycle → Not all courses can be finished ❌

// So the count variable is simply a proof that the topological sort was complete. That's why this single line

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