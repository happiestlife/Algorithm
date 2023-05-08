package P8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P8_13 {

    private static final int NOT_VISIT = 1;

    private static final int VISIT = 2;

    // 북, 북동, 동, 동남, 남, 남서, 서, 북서
    private static final int[] fx = {-1, -1, 0, 1, 1,  1,  0, -1};
    private static final int[] fy = { 0,  1, 1, 1, 0, -1, -1, -1};

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer stk;
        for (int i = 0; i < map.length; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int islandCnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int data = map[i][j];
                if (data == NOT_VISIT) {
                    dfs(i, j);
                    islandCnt++;
                }
            }
        }

        System.out.println(islandCnt);

        br.close();
    }

    private static void dfs(int x, int y) {
        map[x][y] = VISIT;
        for (int i = 0; i < fx.length; i++) {
            int dx = x + fx[i];
            int dy = y + fy[i];

            if ((0 <= dx && dx < map.length)
                    && (0 <= dy && dy < map[0].length)
                    && (map[dx][dy] == NOT_VISIT)) {
                dfs(dx, dy);
            }
        }
    }
}
