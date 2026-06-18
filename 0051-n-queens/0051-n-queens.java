// class Solution {
//     public static boolean isSafe(int row, int col, List<String> board, int n) {
//         int dupRow = row;
//         int dupCol = col;

//         // upper left diagonal 
//         while (row >= 0 && col >= 0) {
//             // see how we are accessing the each index right. 
//             // be care full while working with string since they are not muitable.
//             if (board.get(row).charAt(col) == 'Q') return false;
//             row--;
//             col--;
//         }

//         // left side
//         row = dupRow;
//         col = dupCol;
//         while (col >= 0) {
//             if (board.get(row).charAt(col) == 'Q') return false;
//             col--;
//         }

//         //  lower left diagonal
//         row = dupRow;
//         col = dupCol;
//         while (row < n && col >= 0) {
//             if (board.get(row).charAt(col) == 'Q') return false;
//             row++;
//             col--;
//         }

//         return true;
//     }
//     public static void solve(int col, List<String> board, List<List<String>> ans, int n) {
//         if (col == n) {
//             ans.add(new ArrayList<>(board));
//             return;
//         }

//         // for(int i = col, i<n;i++){ this for loop is wrong right. And here is the reasson why -> if i ask u what is the function call u made solve(0,...) that means this function call is responsible for setting the col 0 right... now suppose we add one valid arrangement right. so when we back track first  we will the row for loop right i.e col = 0 and row - 0 , 1,2,3 right. 

// so  writing this (int i = col, i<n) -> with will make call to all the column right 
// but if we use this ( int i = col; i<=col ) ->  this will only call for one col and then it will stop right.

// because from the main function we call solve(0,..) this is responsibe for setting the col 0 arrangement so it sould only set the  col 0 right.. 


//     for(int i = col; i<= col;i++){ // this will ensure that when we return back at this function we call recusive 
//     // function for col = 0; and row = 0,1,2,3 right 

//     // so the function will look like this col = 0 , row = 0,1,2,3 ; col = 1, row = 0,1,2,3 .... 
//         for (int row = 0; row < n; row++) {
//             if (isSafe(row, i, board, n)) {
//                 char[] rowChars = board.get(row).toCharArray();
//                 rowChars[i] = 'Q';
//                 board.set(row, new String(rowChars));

//                 solve(i + 1, board, ans, n);

//                 // Backtrack
//                 rowChars[i] = '.';
//                 board.set(row, new String(rowChars));
//             }
//         }
//         }
//     }
//     public List<List<String>> solveNQueens(int n) {
//         // to store final answer 
//         List<List<String>> ans = new ArrayList<>();
//         // to store generate each board ["....","....","....","...."];
//         List<String> board = new ArrayList<>();

//         String row = ".".repeat(n);
//         for (int i = 0; i < n; i++) {
//             board.add(row);
//         }
//         // this generate = ["....","....","....","...."];

//         solve(0, board, ans, n);
//         return ans;
        
//     }
// }

// ///////////////// USING SINGLE FOR LOOP ...................

// class Solution {
//     public static boolean isSafe(int row, int col, List<String> board, int n) {
//         int dupRow = row;
//         int dupCol = col;

//         // upper diagonal 
//         while (row >= 0 && col >= 0) {
//             // see how we are accessing the each index right. 
//             // be care full while working with string since they are not muitable.
//             if (board.get(row).charAt(col) == 'Q') return false;
//             row--;
//             col--;
//         }

//         // left side
//         row = dupRow;
//         col = dupCol;
//         while (col >= 0) {
//             if (board.get(row).charAt(col) == 'Q') return false;
//             col--;
//         }

//         //  lower left diagonal
//         row = dupRow;
//         col = dupCol;
//         while (row < n && col >= 0) {
//             if (board.get(row).charAt(col) == 'Q') return false;
//             row++;
//             col--;
//         }

//         return true;
//     }
//     public static void solve(int col, List<String> board, List<List<String>> ans, int n) {
//         if (col == n) {
//             ans.add(new ArrayList<>(board));
//             return;
//         }
//         // note that if u do this i<n then for i = 0; the board will be generated right and when we come back to 
//         // to this recursion we will again for i = 2. which is some thing error.
//         // note that for col = 0 we have to call row 0 1 2 3 . try to think right 
//         // for(int i = col, i<n;i++){     
//     // for(int i = col; i<= col;i++){ // this will ensure that when we return back at this function we call recusive 
//     // function for col = 0; and row = 0,1,2,3 right 

//     // so the function will look like this col = 0 , row = 0,1,2,3 ; col = 1, row = 0,1,2,3 .... 
//         for (int row = 0; row < n; row++) {
//             if (isSafe(row, col, board, n)) {
//                 char[] rowChars = board.get(row).toCharArray();
//                 rowChars[col] = 'Q';
//                 board.set(row, new String(rowChars));

//                 solve(col + 1, board, ans, n);

//                 // Backtrack
//                 rowChars[col] = '.';
//                 board.set(row, new String(rowChars));
//             }
//         }
//         }
    
//     public List<List<String>> solveNQueens(int n) {
//         // to store final answer 
//         List<List<String>> ans = new ArrayList<>();
//         // to store generate each board ["....","....","....","...."];
//         List<String> board = new ArrayList<>();

//         String row = ".".repeat(n);
//         for (int i = 0; i < n; i++) {
//             board.add(row);
//         }
//         // this generate = ["....","....","....","...."];

//         solve(0, board, ans, n);
//         return ans;
        
//     }

// }

/////////////// using hash map ......................................
// we can reduce the time complexity using Hashing 
class Solution {

    public static boolean isSafe(int row, int col, List<String> board,HashMap<Integer, Integer> column,HashMap<Integer, Integer> upper,HashMap<Integer, Integer> lower, int n ) {

       if(column.get(row) == -1) return false;

       int ans = row+col;
       if(upper.get(ans) == -1 ) return false;

       ans = (n-1)+(col-row);
       if(lower.get(ans) == -1) return false;

        return true;
    }
    public static void solve(int col, List<String> board, List<List<String>> ans, int n, HashMap<Integer, Integer> column,HashMap<Integer, Integer> upper,HashMap<Integer, Integer> lower) {
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        // note that if u do this i<n then for i = 0; the board will be generated right and when we come back to 
        // to this recursion we will again for i = 2. which is some thing error.
        // note that for col = 0 we have to call row 0 1 2 3 . try to think right 
        // for(int i = col, i<n;i++){     
    // for(int i = col; i<= col;i++){ // this will ensure that when we return back at this function we call recusive 
    // function for col = 0; and row = 0,1,2,3 right 

    // so the function will look like this col = 0 , row = 0,1,2,3 ; col = 1, row = 0,1,2,3 .... 
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board,column,upper,lower,n)) {
                char[] rowChars = board.get(row).toCharArray();
                rowChars[col] = 'Q';
                column.put(row,-1);
                upper.put(row+col,-1);
                lower.put((n-1)+(col-row),-1);
                board.set(row, new String(rowChars));

                solve(col + 1, board, ans, n,column,upper,lower);

                // Backtrack
                rowChars[col] = '.';
                board.set(row, new String(rowChars));
                column.put(row, 1);
                upper.put(row + col, 1);
                lower.put((n - 1) + (col - row), 1);

            }
        }
        }
    
    public List<List<String>> solveNQueens(int n) {
        // to store final answer 
        List<List<String>> ans = new ArrayList<>();
        // to store generate each board ["....","....","....","...."];
        List<String> board = new ArrayList<>();

         HashMap<Integer, Integer> column = new HashMap<>();

        // Fill with keys 0 to 3 and value = 1
        for (int i = 0; i < n; i++) {
            column.put(i, 1);
        }
         HashMap<Integer, Integer> upper = new HashMap<>();
        for (int i = 0; i < 2*n-1; i++) {
            upper.put(i, 1);
        }

         HashMap<Integer, Integer> lower = new HashMap<>();
        for (int i = 0; i <2*n-1; i++) {
            lower.put(i, 1);
        }




        String row = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(row);
        }
        // this generate = ["....","....","....","...."];

        solve(0, board, ans, n,column,upper,lower);
        return ans;
        
    }
}

