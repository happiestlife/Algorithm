import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static boolean hasCycle;
    private static int result;
    private static int[][] dp;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] comps = br.readLine().split(" ");
        int n = Integer.parseInt(comps[0]);
        int m = Integer.parseInt(comps[1]);

        map = new int[n][m];
        dp = new int[n][m];
        isVisited = new boolean[n][m];
        for(int i = 0; i < map.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                char c = str.charAt(j);
                if(c == 'H') map[i][j] = -1;
                else map[i][j] = c - '0';
            }
        }

        dfs(new Point(0, 0), 0);

        if(hasCycle) System.out.println(-1);
        else System.out.println(result + 1);
    }

    public static void dfs(Point cur, int moveCnt) {
        isVisited[cur.x][cur.y] = true;
        dp[cur.x][cur.y] = moveCnt;
        result = Math.max(result, moveCnt);

        int movePoint = map[cur.x][cur.y];
        for (int i = 0; i < dx.length; i++) {
            int fx = cur.x + movePoint * dx[i];
            int fy = cur.y + movePoint * dy[i];

            if((0 <= fx && fx < map.length) && (0 <= fy && fy < map[fx].length)
                    && map[fx][fy] != -1) {
                if(isVisited[fx][fy]) {
                    hasCycle = true;
                    return;
                }

                if(dp[fx][fy] >= moveCnt + 1) continue;

                dfs(new Point(fx, fy), moveCnt + 1);
                if(hasCycle) return;
            }
        }

        isVisited[cur.x][cur.y] = false;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}