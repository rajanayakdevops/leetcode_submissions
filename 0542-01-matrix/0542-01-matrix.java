    class Solution {
    public int[][] updateMatrix(int[][] arr) {
        // note that in this question we are ewquired to find the nearest 0 right.
        // logic suppose u start from a mid point(i) right and when u go in all the four direction u reach
        // at point say a,b,c,d right so can i say that a,b,c,d are at distance 1 from the i right.
        // vice versa i can also say that i at distance of 1 from all of a,b,c,d rigt. both the statement
        // are right.

        // to taverse in all the direction what we are using BFS right;
        // step 1: insert all the 0 in to the queue with the distance 0. right because all the 0's are
        // are at distance 0 from itself right;
        
        // step 2 : now form any of the these four direction its neighbours will be at a distace + 1

// code idea is i start from all 0 right and which ever bfs call is made next will definately be called for unvisited cell right i.e the cell value is 100% not 0, but it was zero then in that case it would have
// been marked visited right. and if we are calling bfs for that then it is not visited right;

        int r = arr.length;
        int c = arr[0].length;

        Queue<int[]> queue = new LinkedList<>();

        boolean visited[][] = new boolean[r][c];
        for(int i = 0; i<r;i++){
            for( int j = 0; j<c;j++){
                if(arr[i][j] == 0){
                    queue.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        // after the for loop is ended the queue is filled with all the cell having value 0 right;
        // we have added cell with value 0 because we are asked to find the min distance to the nearest 0;
        // and we know 0 is at 0 distance from itself right;

        // now thw next work is to remove the element form the queue 


        int ans[][] = new int[r][c];

        while( !queue.isEmpty()){
                int val[] = queue.poll();
                int row = val[0];
                int col = val[1];

                //marking the answer array 
                int distance = val[2];

                // after removing mark that cell in the ans array with the min distance
                ans[row][col] = distance;

                // now i have to in all the four direction right;
                bfs(row+1,col,visited,queue,distance);
                bfs(row-1,col,visited,queue,distance);
                bfs(row,col+1,visited,queue,distance);
                bfs(row,col-1,visited,queue,distance);
                
        }

        return ans;

        
    }

    public static void bfs(int row, int col, boolean[][]visited, Queue<int[]> queue, int dist){
            if(row >= 0 && col >= 0  && row < visited.length && col < visited[0].length 
            && !visited[row][col]){

                visited[row][col] = true;
                queue.offer(new int[]{row,col,dist+1});

            }
    }
}