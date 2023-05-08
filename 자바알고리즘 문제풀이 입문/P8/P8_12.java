package P8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P8_12 {

    static final int NOT_RIPEN_APPLE = 0;

    static final int RIPEN_APPLE = 1;

    // 상, 우, 하, 좌
    private static final int[] fx = {-1, 0, 1,  0};
    private static final int[] fy = { 0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        int[][] map = new int[n][m];
        // [0] : x, [1] : y
        Queue<int[]> q = new LinkedList<>();
        int notRipenAppleCnt = 0;
        for (int i = 0; i < map.length; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());

                if(map[i][j] == RIPEN_APPLE) {
                    q.add(new int[]{i, j, 0});
                    // 큐에서 나오기 때문
                    notRipenAppleCnt++;
                }else if(map[i][j] == 0)
                    notRipenAppleCnt++;
            }
        }

        int rs = 0;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            rs = map[node[0]][node[1]] - 1;
            notRipenAppleCnt--;
            if(notRipenAppleCnt == 0)
                break;

            for (int i = 0; i < fx.length; i++) {
                int dx = node[0] + fx[i];
                int dy = node[1] + fy[i];

                if ((0 <= dx && dx < map.length)
                        && (0 <= dy && dy < map[0].length)
                        && (map[dx][dy] == NOT_RIPEN_APPLE)) {
                    q.add(new int[]{dx, dy});
                    map[dx][dy] = map[node[0]][node[1]] + 1;
                }
            }
            if(notRipenAppleCnt == 0)
                break;
        }

        if(notRipenAppleCnt > 0)
            rs = -1;

        System.out.println(rs);

        br.close();
    }
}
