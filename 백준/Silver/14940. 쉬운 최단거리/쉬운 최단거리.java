import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] map = new int[n][m];
        int[] target = new int[2];
        for (int i = 0; i < map.length; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 2){
                    target[0] = i;
                    target[1] = j;
                }
            }
        }


        int[][] dist = getDistToTarget(map, target[0], target[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

        br.close();
    }

    public static int[][] getDistToTarget(int[][] map, int x, int y) {
        final int[] dx = {-1, 0, 1, 0};
        final int[] dy = {0, 1, 0, -1};

        boolean[][] isVisited = new boolean[map.length][map[0].length];
        int[][] dist = new int[map.length][map[0].length];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        isVisited[x][y] = true;
        while (!q.isEmpty()) {
            int[] point = q.poll();
            x = point[0];
            y = point[1];

            for (int i = 0; i < dx.length; i++) {
                int fx = x + dx[i];
                int fy = y + dy[i];

                if ((0 <= fx && fx < map.length) &&
                        (0 <= fy && fy < map[fx].length) &&
                        !isVisited[fx][fy]) {
                    if(map[fx][fy] != 0) {
                        dist[fx][fy] = dist[x][y] + 1;
                        q.add(new int[]{fx, fy});
                    }
                    isVisited[fx][fy] = true;
                }
            }
        }

        for (int i = 0; i < isVisited.length; i++) {
            for (int j = 0; j < isVisited[i].length; j++) {
                if(!isVisited[i][j] && map[i][j] == 1){
                    dist[i][j] = -1;
                }
            }
        }

        return dist;
    }

}
