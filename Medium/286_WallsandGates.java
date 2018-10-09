/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example: 

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
*/

class Solution {
/*
    private int[] dirX = {0, 0, -1, 1};
    private int[] dirY = {-1, 1, 0, 0};
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[i].length; ++j) {
                if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
            }
        }
    }
    private void dfs(int[][] rooms, int x, int y, int depth) {
        if (!isValid(rooms, x, y) || rooms[x][y] < depth) return;
        rooms[x][y] = depth;
        for (int i = 0; i < dirX.length; ++i) dfs(rooms, x + dirX[i], y + dirY[i], depth + 1);
    }
    private boolean isValid(int[][] rooms, int x, int y) {
        return x >= 0 && x < rooms.length && y >= 0 && y < rooms[x].length && rooms[x][y] != -1;
    }*/
/*
    private int[] dirX = {0, 0, -1, 1};
    private int[] dirY = {-1, 1, 0, 0};
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[i].length; ++j) {
                if (rooms[i][j] == 0) que.add(new int[]{i, j});
            }
        }
        int depth = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; ++i) {
                int[] top = que.poll();
                for (int j = 0; j < dirX.length; ++j) {
                    int newX = top[0] + dirX[j];
                    int newY = top[1] + dirY[j];
                    if (isValid(rooms, newX, newY) && rooms[newX][newY] > depth + 1) {
                        rooms[newX][newY] = depth + 1;
                        que.add(new int[]{newX, newY});
                    }
                }
            }
            depth++;
        }
    }
    private boolean isValid(int[][] rooms, int x, int y) {
        return x >= 0 && x < rooms.length && y >= 0 && y < rooms[x].length && rooms[x][y] != -1;
    }*/
    private int[] dirX = {0, 0, -1, 1};
    private int[] dirY = {-1, 1, 0, 0};
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[i].length; ++j) {
                if (rooms[i][j] == 0) que.add(new int[]{i, j});
            }
        }
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; ++i) {
                int[] top = que.poll();
                for (int j = 0; j < dirX.length; ++j) {
                    int newX = top[0] + dirX[j];
                    int newY = top[1] + dirY[j];
                    if (isValid(rooms, newX, newY) && rooms[newX][newY] > rooms[top[0]][top[1]] + 1) {
                        rooms[newX][newY] = rooms[top[0]][top[1]] + 1;
                        que.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
    private boolean isValid(int[][] rooms, int x, int y) {
        return x >= 0 && x < rooms.length && y >= 0 && y < rooms[x].length && rooms[x][y] != -1;
    }
}