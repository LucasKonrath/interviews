package backTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueensBacktracking {

    public static void main(final String[] args) {
        final NQueensBacktracking backtracking = new NQueensBacktracking();
        backtracking.solveNQueens(11);
    }

    /**
     * Input: n = 4 Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]] 1 <= n <= 9
     */
    public List<List<String>> solveNQueens(final int n) {

        if (n == 0) {
            return Collections.emptyList();
        }

        final List<List<String>> results = new ArrayList<>();

        final int[][] board = new int[n][n];

        placeQueen(0, 0, board, results, false, n);

        return results;
    }

    public void placeQueen(int rownum, final int colnum, final int[][] board, final List<List<String>> results,
        final boolean shouldDeleteLastQueen, int boardSize) {

        // for security reasons, to avoid array index out of bounds
        if (rownum >= boardSize || colnum >= boardSize) {
            return;
        }

        // if recursion has ended (is at last row of first column and coming off a failed attempt)
        if (rownum == boardSize && shouldDeleteLastQueen) {
            return;
        }

        if (shouldDeleteLastQueen) {
            for (int i = 0; i < boardSize; i++) {
                if (board[i][colnum] == 1) {

                    board[i][colnum] = 0;
                    rownum = i + 1;

                    if (i == boardSize - 1 && colnum > 0) {
                        placeQueen(0, colnum - 1, board, results, true, boardSize);
                        return;
                    }

                    break;

                }
            }
        }

        // check colnum -> horizontal to see if queen has been placed
        // check diagonals to see if queen has been placed
        if (!checkHorizontal(rownum, colnum, board) || !checkLowerLeft(rownum, colnum, board) || !checkUpperLeft(rownum,
            colnum, board)) {
            if (rownum == boardSize - 1) {
                placeQueen(0, colnum - 1, board, results, true, boardSize);
                return;
            } else if (rownum == boardSize) {
                return;
            } else {
                placeQueen(rownum + 1, colnum, board, results, false, boardSize);
                return;
            }
        }

        board[rownum][colnum] = 1;

        if (colnum == board[0].length - 1) {

            results.add(printBoard(board));

            if (rownum == board[0].length - 1 && colnum != boardSize - 1) {
                placeQueen(0, colnum - 1, board, results, true, boardSize);
            } else {
                placeQueen(0, colnum, board, results, true, boardSize);
            }
            return;
        }

        placeQueen(0, colnum + 1, board, results, false, boardSize);
        return;
    }

    private List<String> printBoard(final int[][] board) {
        final List<String> results = new ArrayList<>();
        StringBuilder values = new StringBuilder();

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] == 1) {
                    values.append("Q");
                } else {
                    values.append(".");
                }
            }
            results.add(values.toString());
            values = new StringBuilder();
        }
        return results;
    }

    private boolean checkHorizontal(final int rownum, final int colnum, final int[][] board) {
        if (colnum == 0) {
            return true;
        }

        for (int i = 0; i <= colnum; i++) {
            if (board[rownum][i] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLowerLeft(int rownum, int colnum, final int[][] board) {
        if (rownum == board[0].length - 1) {
            return true;
        }

        while (colnum >= 0 && rownum <= board[0].length - 1) {
            if (board[rownum][colnum] == 1) {
                return false;
            }
            rownum++;
            colnum--;
        }
        return true;
    }

    private boolean checkUpperLeft(int rownum, int colnum, final int[][] board) {

        if (rownum == 0) {
            return true;
        }

        while (colnum >= 0 && rownum >= 0) {

            if (colnum < 0 || rownum < 0) {
                return true;
            }

            try {
                if (board[rownum][colnum] == 1) {
                    return false;
                }
            } catch (final ArrayIndexOutOfBoundsException aee) {
                return false;
            }
            rownum--;
            colnum--;
        }
        return true;
    }
}
