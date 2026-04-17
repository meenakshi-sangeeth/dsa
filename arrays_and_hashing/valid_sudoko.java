/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

- Each row must contain the digits 1-9 without repetition.
- Each column must contain the digits 1-9 without repetition.
- Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
- A Sudoku board (partially filled) could be valid but is not necessarily solvable.
- Only the filled cells need to be validated according to the mentioned rules.

Example:
- Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
- Output: true
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[10][10];
        int[][] col = new int[10][10];
        int[][] sub = new int[10][10];
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]=='.')
                    continue;
                int val=board[i][j]-'0';
                if (row[i][val]==1)
                    return false;
                row[i][val]=1;
                if (col[j][val]==1)
                    return false;
                col[j][val]=1;
                int idx=(i/3)*3+j/3;
                if (sub[idx][val]==1)
                    return false;
                sub[idx][val]=1;
                
            }
        
        }
        return true;
    }
}

