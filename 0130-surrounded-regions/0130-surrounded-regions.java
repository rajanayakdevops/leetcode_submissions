class Solution {

    int[] drow = {-1,0,1,0};

    int[] dcol = {0,1,0,-1};

    public void dfs(int row, int col, char[][] arr, int n, int m ){

        arr[row][col] = '#';

        for(int i = 0;i<4;i++){
            int newrow = row+drow[i];
            int newcol = col+dcol[i];

            if(newrow >= 0 && newrow <n && newcol >= 0 && newcol < m && arr[newrow][newcol] == 'O'){
                    dfs(newrow,newcol,arr,n,m);
            }
        }

        
    }
    public void solve(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0;i<m;i++){
            if(arr[0][i] == 'O')
            dfs(0,i,arr,n,m);
        }
        for(int i = 0;i<m;i++){
            if(arr[n-1][i] == 'O')
            dfs(n-1,i,arr,n,m);
        }

        for(int i = 0;i<n;i++){
            if(arr[i][0] == 'O'){
                dfs(i,0,arr,n,m);
            }
        }

        for(int i = 0;i<n;i++){
            if(arr[i][m-1] == 'O'){
                dfs(i,m-1,arr,n,m);
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j] == '#'){
                    arr[i][j] = 'O';
                }else{
                    arr[i][j] = 'X';
                }
            }
        }

        
    }
}