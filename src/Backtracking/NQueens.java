package Backtracking;

public class NQueens {
    public static void placeQueens(int n){
        int board[][] = new int[n][n];

        placeNQueens(board, n, 0);
    }

    private static void placeNQueens(int[][] board, int n, int row){
        // Base Case- if we successfully places queens for all rows
        if(row == n){
            for(int[] arr: board){
                for(int i: arr){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        // Check for all column
        for(int col=0; col<board.length; col++){
            // check if its safe to place queen at this pos
            if(isPosSafe(board, row, col)) {
                board[row][col] = 1;
                // move to next row
                placeNQueens(board, n, row + 1);
                // reset board pos to zero
                board[row][col] = 0;
            }
        }
    }

    private static boolean isPosSafe(int[][] board, int row, int col){
        // check top positions
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 1){
                return false;
            }
        }
        // check left diagonal positions
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        // check right diagonal positions
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        placeQueens(5);
    }
}
