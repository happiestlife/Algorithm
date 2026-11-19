import java.util.*;
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] isVisited = new boolean[m][n];
                if(dfs(board, word, i, j, isVisited, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String target, int x, int y, boolean[][] isVisited, int tIdx) {
        char boardChar = board[x][y];
        char targetChar = target.charAt(tIdx);
        isVisited[x][y] = true;
        if(boardChar != targetChar) {
            isVisited[x][y] = false;
            return false;
        }
        else if(tIdx == target.length()-1) {
            return true;
        }


        int[] dx = {0, 1,  0, -1};
        int[] dy = {1, 0 ,-1,  0};
        int m = board.length, n = board[0].length;
        for(int i = 0; i < dx.length; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if(
                (fx < 0 || fx >= m) ||
                (fy < 0 || fy >= n) ||
                isVisited[fx][fy]
            ) {
                continue;
            } 
            boolean findTarget = dfs(board, target, fx, fy, isVisited, tIdx+1);
            if(findTarget) return true;
        }
        
        isVisited[x][y] = false;
        return false;
    }
}