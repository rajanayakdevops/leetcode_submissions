class Solution {

    public void bfs(int node, boolean[] visited, int[][] arr){
        visited[node] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            int curr_node = q.poll();
            for(int i = 0;i<arr[curr_node].length;i++){
            if(i != curr_node && visited[i] == false && arr[curr_node][i] == 1){
                visited[i] = true;
                q.offer(i);

            }
        }
            
        }
    }

    public int findCircleNum(int[][] arr) {
        
        Queue<Integer> q = new LinkedList<>();

        int count = 0;
        int n = arr.length;

        boolean[] visited = new boolean[n];
        

        for(int i = 0;i<n;i++){
            if(visited[i] == false){
                bfs(i,visited,arr);
            count++;
            }
        }

        return count;
    }
}