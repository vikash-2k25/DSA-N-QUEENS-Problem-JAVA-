public class vikash {

    // Function to print the board
    static void printBoard(int board[][], int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if queen can be placed safely
    static boolean isSafe(int board[][], int row, int col, int N) {
        // Check column above
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }



        return true;
    }

    // Solve N Queens using backtracking
    static boolean solveNQUtil(int board[][], int row, int N) {
        // If all queens are placed
        if (row == N) {
            printBoard(board, N);
            return true;
        }

        boolean res = false;
        // Try placing queen in all columns
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col, N)) {
                board[row][col] = 1; // place queen
                res = solveNQUtil(board, row + 1, N) || res;
                board[row][col] = 0; // backtrack
            }
        }

        return res;
    }

    // Main function to solve problem
    static void solveNQ(int N) {
        int board[][] = new int[N][N];

        if (!solveNQUtil(board, 0, N)) {
            System.out.println("No Solution exists");
        }
    }

    public static void main(String[] args) {
        int N = 6; // You can change value of N
        solveNQ(N);
    }
}




