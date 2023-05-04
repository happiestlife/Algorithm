package P8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P8_11 {
    private static final int PATH = 0;

    private static final int WALL = 1;

    private static final int VISIT = 2;

    // 상, 우, 하, 좌
    private static final int[] fx = {-1, 0, 1,  0};
    private static final int[] fy = { 0, 1, 0, -1};

    private static int[][] map = new int[7][7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < map.length; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // [0] : x, [1] : y, [2] : 거리
        int rs = -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        boolean isSuccess = false;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int i = 0; i < fx.length; i++) {
                int dx = node[0] + fx[i];
                int dy = node[1] + fy[i];

                if ((0 <= dx && dx < map.length)
                        && (0 <= dy && dy < map.length)
                        && (map[dx][dy] == PATH)) {
                    if (dx == map.length - 1 && dy == map.length - 1) {
                        rs = node[2] + 1;
                        isSuccess = true;
                        break;
                    }

                    q.add(new int[]{dx, dy, node[2] + 1});
                    map[dx][dy] = VISIT;
                }
            }
            if(isSuccess)
                break;
        }

        System.out.println(rs);

        br.close();
    }
}
