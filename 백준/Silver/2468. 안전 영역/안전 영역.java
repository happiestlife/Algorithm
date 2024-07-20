import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int minHeight = 101;
        int maxHeight = 0;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(stk.nextToken());
                maxHeight = Math.max(maxHeight, graph[i][j]);
                minHeight = Math.min(minHeight, graph[i][j]);
            }
        }

        int maxSafeAreaCnt = 0;
        for (int curHeight = minHeight - 1; curHeight < maxHeight; curHeight++) {
            maxSafeAreaCnt = Math.max(maxSafeAreaCnt, getSafeAreaCount(graph, n, curHeight));
        }
        System.out.println(maxSafeAreaCnt);

        br.close();
    }

    private static int getSafeAreaCount(int[][] graph, int graphSize, int waterHeight) {
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};

        int areaCnt = 0;
        boolean[][] isVisited = new boolean[graphSize][graphSize];

        for (int i = 0; i < graphSize; i++) {
            for (int j = 0; j < graphSize; j++) {
                if (!isSafeArea(graph, isVisited, waterHeight, i, j)) continue;

                // [0]: x, [1]: y
                Queue<Point> q = new LinkedList<>();
                q.add(new Point(i, j));
                isVisited[i][j] = true;
                while (!q.isEmpty()) {
                    Point p = q.poll();

                    for (int k = 0; k < dx.length; k++) {
                        int fx = p.x + dx[k];
                        int fy = p.y + dy[k];

                        if(!isSafeArea(graph, isVisited, waterHeight, fx, fy)) continue;

                        q.add(new Point(fx, fy));
                        isVisited[fx][fy] = true;
                    }
                }
                areaCnt++;
            }
        }

        return areaCnt;
    }

    private static boolean isSafeArea(int[][] graph, boolean[][] isVisited, int waterHeight, int x, int y) {
        return ((0 <= x && x < graph.length) && (0 <= y && y < graph[x].length)) &&
                !isVisited[x][y] &&
                graph[x][y] > waterHeight;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}