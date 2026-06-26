class pair{
    int row;
    int col;
    int time;

    public pair(int row, int col, int time ){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] arr) {
        int ans = 0;
        int n = arr.length;
        int m = arr[0].length;
        Queue<pair> q = new LinkedList<>();

        int rotten = 0;

        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j] == 2 ){
                    q.offer(new pair(i,j,0));
                    rotten++;
                }
            }
        }
        
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty()){
            pair current = q.poll();
            int row = current.row;
            int col = current.col;

            int time = current.time;

            ans = Math.max(ans,time);

            for(int i = 0;i<4;i++){
                int newrow = row+drow[i];
                int newcol = col+dcol[i];

                if(newrow >= 0 && newrow <n && newcol >=0 && newcol < m && arr[newrow][newcol] == 1 ){
                    arr[newrow][newcol] = 2;
                    q.offer(new pair(newrow,newcol,time+1));
                }
            }


        }

        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j] == 1){
                    return -1;
                }
            }
        }

        return ans;

    }
}