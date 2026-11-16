import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        final int[] dx = {0, 1,  0, -1};
        final int[] dy = {1, 0, -1,  0};

        int m = matrix.length, n = matrix[0].length;

        boolean[][] isVisited = new boolean[m][n];
        int visitCnt = 0;

        int moveDirect = 0;
        int x = 0, y = 0;
        List<Integer> result = new ArrayList<>(m*n);
        while(true) {
            isVisited[x][y] = true;
            visitCnt++;
            result.add(matrix[x][y]);
            if(visitCnt == m*n) break;

            int fx = x + dx[moveDirect];
            int fy = y + dy[moveDirect];
            if(isPointOutside(m, n, fx, fy) || isVisited[fx][fy]) {
                moveDirect = (moveDirect+1) % dx.length;
                fx = x + dx[moveDirect];
                fy = y + dy[moveDirect];
            }

            x = fx;
            y = fy;
        }

        return result;
    }

    private boolean isPointOutside(int m, int n, int x, int y) {
        return (
            (x < 0 || x >= m) ||
            (y < 0 || y >= n)
        );
    }
}