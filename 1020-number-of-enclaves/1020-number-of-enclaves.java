
class Solution {

    int[] drow = {-1,0,1,0};

    int[] dcol = {0,1,0,-1};

    public void dfs(int row, int col, int[][] arr, int n, int m ){

        arr[row][col] = 0;

        for(int i = 0;i<4;i++){
            int newrow = row+drow[i];
            int newcol = col+dcol[i];

            if(newrow >= 0 && newrow <n && newcol >= 0 && newcol < m && arr[newrow][newcol] == 1){
                    dfs(newrow,newcol,arr,n,m);
            }
        }

        
    }
    public int numEnclaves(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int count = 0;

        for(int i = 0;i<m;i++){
            if(arr[0][i] == 1)
            dfs(0,i,arr,n,m);
        }
        for(int i = 0;i<m;i++){
            if(arr[n-1][i] == 1)
            dfs(n-1,i,arr,n,m);
        }

        for(int i = 0;i<n;i++){
            if(arr[i][0] == 1){
                dfs(i,0,arr,n,m);
            }
        }

        for(int i = 0;i<n;i++){
            if(arr[i][m-1] == 1){
                dfs(i,m-1,arr,n,m);
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j] == 1 ) count++;
            }
        }

        return count;

        
    }
}