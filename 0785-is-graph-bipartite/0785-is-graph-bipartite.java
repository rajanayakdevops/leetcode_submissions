class Solution {


    public boolean dfs(int node,Boolean[] visited,int[][] graph , boolean flag){
        
        visited[node] = flag;

        for(int i : graph[node]){
            if(visited[i] == null ){
                if(dfs(i,visited,graph,!flag) == false) return false ;
            }
            else if(visited[i] == flag) return false;
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            Boolean[] visited = new Boolean[n];

            // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            // for(int i = 0;i<n;i++){
            //     adj.add(new ArrayList<>());
            // }

            // for(int i = 0;i<n;i++){
            //     for(int v : graph[i]){
            //         adj.get(i).add(v);
            //     }
            // }

            for(int i = 0;i<n;i++){
                if(visited[i] == null ){
                    if(dfs(i,visited,graph,true) == false) return false;
                }
            }   

            return true;
    }
}