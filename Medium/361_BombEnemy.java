/*
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note: You can only put the bomb at an empty cell.

Example:

Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3 
Explanation: For the given grid,

0 E 0 0 
E 0 W E 
0 E 0 0

Placing a bomb at (1,1) kills 3 enemies.
*/

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '0') {
                    res = Math.max(res, helper(grid, i, j));
                }
            }
        }
        return res;
    }
    private int helper(char[][] grid, int i, int j) {
        int cnt = 0;
        for (int k = i; k >= 0; --k) {
            if (grid[k][j] == 'E') ++cnt;
            if (grid[k][j] == 'W') break;
        }
        for (int k = i; k < grid.length; ++k) {
            if (grid[k][j] == 'E') ++cnt;
            if (grid[k][j] == 'W') break;
        }
        for (int k = j; k >= 0; --k) {
            if (grid[i][k] == 'E') ++cnt;
            if (grid[i][k] == 'W') break;
        }
        for (int k = j; k < grid[i].length; ++k) {
            if (grid[i][k] == 'E') ++cnt;
            if (grid[i][k] == 'W') break;
        }
        return cnt;
    }
}