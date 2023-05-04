package P8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P8_10 {

    private static final int PATH = 0;

    private static final int WALL = 1;

    private static final int VISIT = 2;

    // 상, 우, 하, 좌
    private static final int[] fx = {-1, 0, 1,  0};
    private static final int[] fy = { 0, 1, 0, -1};

    private static int count;

    private static int[][] map = new int[7][7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < map.length; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(count);

        br.close();
    }

    private static void dfs(int x, int y) {
        if (x == map.length - 1 && y == map.length - 1) {
            count++;
            return;
        }

        map[x][y] = VISIT;

        for (int i = 0; i < fx.length; i++) {
            int dx = x + fx[i];
            int dy = y + fy[i];

            if ((0 <= dx && dx < map.length)
                    && (0 <= dy && dy < map.length)
                    && (map[dx][dy] == PATH)) {
                dfs(dx, dy);
            }
        }

        map[x][y] = PATH;
    }
}
