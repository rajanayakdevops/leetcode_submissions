class Solution {
    public List<Integer> eventualSafeNodes(int[][] arr) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = arr.length;

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<arr[i].length;j++){
                adj.get(arr[i][j]).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        List<Integer> ans = new ArrayList<>();

        for(int i = 0;i<n;i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int current = q.poll();
            ans.add(current);

            for(int val : adj.get(current)){
                indegree[val]--;

                if(indegree[val] == 0 ){
                    q.offer(val);
                }
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}