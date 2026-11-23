import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] wire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        wire = new int[N][2];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(stk.nextToken());
            wire[i][1] = Integer.parseInt(stk.nextToken());
        }

        // TODO: 풀이
        Arrays.sort(wire, Comparator.comparingInt(w -> w[0]));
        int max = 0;
        int[] dp = new int[N];
        for(int i = 0; i < dp.length; i++) {
            int curEnd = wire[i][1];

            int maxLen = 0;
            for(int j = 0; j < i; j++) {
                if(wire[j][1] < curEnd) {
                    maxLen = Math.max(maxLen, dp[j]);
                }
            }

            dp[i] = maxLen + 1;
            max = Math.max(max, dp[i]);
        }

        System.out.println(N-max);

        br.close();
    }
}
