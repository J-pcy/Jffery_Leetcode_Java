/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/

class Solution {
/*
    private int[] dirX = {-1, 1, 0, 0, -1, -1, 1, 1};
    private int[] dirY = {0, 0, -1, 1, -1, 1, -1, 1};
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int[][] tmp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                tmp[i][j] = board[i][j];
                if (board[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < dirX.length; ++k) {
                        int newX = i + dirX[k];
                        int newY = j + dirY[k];
                        if (isValid(board, newX, newY) && board[newX][newY] == 1) ++cnt;
                    }
                    if (cnt < 2) tmp[i][j] = 0;
                    if (cnt > 3) tmp[i][j] = 0;
                }
                if (board[i][j] == 0) {
                    int cnt = 0;
                    for (int k = 0; k < dirX.length; ++k) {
                        int newX = i + dirX[k];
                        int newY = j + dirY[k];
                        if (isValid(board, newX, newY) && board[newX][newY] == 1) ++cnt;
                    }
                    if (cnt == 3) tmp[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                board[i][j] = tmp[i][j];
            }
        }
    }
    private boolean isValid(int[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }*/
    private int[] dirX = {-1, 1, 0, 0, -1, -1, 1, 1};
    private int[] dirY = {0, 0, -1, 1, -1, 1, -1, 1};
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 1 || board[i][j] == 2) {
                    int cnt = 0;
                    for (int k = 0; k < dirX.length; ++k) {
                        int newX = i + dirX[k];
                        int newY = j + dirY[k];
                        if (isValid(board, newX, newY) && (board[newX][newY] == 1 || board[newX][newY] == 2)) ++cnt;
                    }
                    if (cnt < 2) board[i][j] = 2;
                    if (cnt > 3) board[i][j] = 2;
                }
                if (board[i][j] == 0 || board[i][j] == 3) {
                    int cnt = 0;
                    for (int k = 0; k < dirX.length; ++k) {
                        int newX = i + dirX[k];
                        int newY = j + dirY[k];
                        if (isValid(board, newX, newY) && (board[newX][newY] == 1 || board[newX][newY] == 2)) ++cnt;
                    }
                    if (cnt == 3) board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
    private boolean isValid(int[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }
}