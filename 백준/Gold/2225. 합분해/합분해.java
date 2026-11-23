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

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());


        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i < dp.length; i++) dp[i][1] = 1;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int l = 0; l <= i; l++) {
                    if(j-1 >= 0) dp[i][j] = (int)(((long)dp[i][j] + dp[l][j-1]) % 1_000_000_000);
                }
            }
        }

        System.out.println(dp[n][k]);

        br.close();
    }
}
