class pair{
    int row;
    int col;
    int color;
    
    public pair(int row,int col, int color){
        this.row = row;
        this.col = col;
        this.color = color;

    }
}

class Solution {
    public int[][] floodFill(int[][] arr, int sr, int sc, int color) {
        Queue<pair> q = new LinkedList<>();

        if(arr[sr][sc] == color ) return arr;

        int n = arr.length;
        int m = arr[0].length;
        q.offer(new pair(sr,sc,arr[sr][sc])); 
        arr[sr][sc] = color;

         int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};


        while(!q.isEmpty()){
            pair current = q.poll();
            int row = current.row;
            int col = current.col;
            int prevCol = current.color;

            for(int i = 0;i<4;i++){
                int newrow = row+drow[i];
                int newcol = col+dcol[i];

                if(newrow >= 0 && newrow < n && newcol >=0 && newcol < m && arr[newrow][newcol] == prevCol){
                    q.offer(new pair(newrow,newcol,prevCol));
                    arr[newrow][newcol] = color;
                }
            }

            


        }

        return arr;

    }
}