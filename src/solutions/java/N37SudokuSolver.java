package solutions.java;

public class N37SudokuSolver {

    public void solveSudoku(char[][] board) {
        doSolve(board);
    }

    public boolean doSolve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (doSolve(board)) {
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int partRow = (row / 3) * 3;
        int partCol = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num || board[row][i] == num || board[partRow + i / 3][partCol + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
