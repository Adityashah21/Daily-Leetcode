class Solution {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {

            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }

            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {

        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'S';

        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
    }
}