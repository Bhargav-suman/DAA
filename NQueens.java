public class NQueens {

    static final int N = 8; // Change N to the desired size of the chessboard

    // Function to print the chessboard
    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to check if it's safe to place a queen at board[row][col]
    static boolean isSafe(int[][] board, int row, int col) {
        // Check this row on the left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Function to solve N-Queens problem using backtracking
    static boolean solveNQueens(int[][] board, int col) {
        if (col == N) {
            // All queens are placed successfully
            printBoard(board);
            return true;
        }

        boolean res = false;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                // Place this queen in board[i][col]
                board[i][col] = 1;

                // Recur to place rest of the queens
                res = solveNQueens(board, col + 1) || res;

                // If placing queen in board[i][col] doesn't lead to a solution,
                // then remove queen (backtrack)
                board[i][col] = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];

        if (!solveNQueens(board, 0)) {
            System.out.println("Solution does not exist.");
        }
    }
}
