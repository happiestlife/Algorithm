import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] candy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        candy = new int[N][M];
        for (int r = 0; r < N; r++) {
            stk = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                candy[r][c] = Integer.parseInt(stk.nextToken());
            }
        }

        // TODO: 풀이
        int[][] dp = new int[N][M];
        dp[0][0] = candy[0][0];

        int[] dx = {-1, 0, -1};
        int[] dy = {-1, -1, 0};
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int curCandy = candy[i][j];
                int maxPrev = 0;
                // 이전 노드 -> 현재 노드로의 캔드합 중 가장 큰 경로 채택
                for (int k = 0; k < dx.length; k++) {
                    int fx = i + dx[k];
                    int fy = j + dy[k];

                    if(
                        (fx < 0 || fx >= N) ||
                        (fy < 0 || fy >= M)
                    ) continue;

                    maxPrev = Math.max(maxPrev, dp[fx][fy]);
                }
                dp[i][j] = curCandy + maxPrev;
            }
        }

        System.out.println(dp[N - 1][M - 1]);

        br.close();
    }
}
