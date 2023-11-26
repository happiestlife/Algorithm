import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int NO_TOMATO = -1;
        final int UNRIPPEN_TOMATO = 0;
        final int RIPPEN_TOMATO = 1;

        final int[] dx = {0, 1, 0, -1, 0, 0};
        final int[] dy = {1, 0, -1, 0, 0, 0};
        final int[] dz = {0, 0, 0, 0, 1, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());
        int h = Integer.parseInt(stk.nextToken());

        int[][][] box = new int[h][n][m];

        int canRippedTomato = 0;
        int rippedTomatoCnt = 0;
        boolean[][][] isVisited = new boolean[h][n][m];
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                stk = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(stk.nextToken());
                    if (box[i][j][k] == RIPPEN_TOMATO) {
                        q.add(new Point(i, j, k, 0));
                        isVisited[i][j][k] = true;
                        rippedTomatoCnt++;
                    }

                    if(box[i][j][k] != NO_TOMATO){
                        canRippedTomato++;
                    }
                }
            }
        }

        int rs = canRippedTomato == rippedTomatoCnt ? 0 : -1;
        while (!q.isEmpty()) {
            Point node = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int fx = node.x + dx[i];
                int fy = node.y + dy[i];
                int fz = node.z + dz[i];

                if ((0 <= fx && fx < n) &&
                        (0 <= fy && fy < m) &&
                        (0 <= fz && fz < h) &&
                        box[fz][fx][fy] == UNRIPPEN_TOMATO && !isVisited[fz][fx][fy]) {
                    q.add(new Point(fz, fx, fy, node.cnt + 1));
                    box[fz][fx][fy] = RIPPEN_TOMATO;
                    isVisited[fz][fx][fy] = true;
                    rippedTomatoCnt++;

                    if (rippedTomatoCnt == canRippedTomato) {
                        rs = node.cnt + 1;
                        break;
                    }
                }
            }
        }

        System.out.println(rs);


        br.close();
    }

}

class Point {
    int x;
    int y;
    int z;
    int cnt;

    public Point(int z, int x, int y, int cnt) {
        this.z = z;
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
