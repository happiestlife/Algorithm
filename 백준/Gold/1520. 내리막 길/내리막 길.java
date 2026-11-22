import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(stk.nextToken()); // 세로 크기
        int N = Integer.parseInt(stk.nextToken()); // 가로 크기

        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // 내리막으로만 이동하므로 높은 칸 -> 낮은 칸 순서로 처리하면
        // 어떤 칸에 도달하기 전에 그 칸으로 들어오는 모든 칸이 이미 처리되어 있다.
        Integer[] order = new Integer[M * N];
        for (int i = 0; i < M * N; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> map[b / N][b % N] - map[a / N][a % N]);

        // dp[x][y] = (0,0)에서 출발해 (x,y)까지 내리막길로 오는 경로의 수
        int[][] dp = new int[M][N];
        dp[0][0] = 1;

        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, -1, 0, 1};
        for (int idx : order) {
            int x = idx / N, y = idx % N;
            if (dp[x][y] == 0) continue; // 출발점에서 도달 불가능한 칸

            for (int d = 0; d < 4; d++) {
                int fx = x + dx[d];
                int fy = y + dy[d];
                if (fx < 0 || fx >= M || fy < 0 || fy >= N) continue;
                if (map[fx][fy] >= map[x][y]) continue; // 내리막이 아니면 이동 불가

                dp[fx][fy] += dp[x][y];
            }
        }

        System.out.println(dp[M - 1][N - 1]);

        br.close();
    }
}

/**
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
-> 3

3 3
9 8 7
8 1 6
7 6 5

3 3
9 2 3
8 1 4
7 6 5
 */
