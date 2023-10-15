import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[101][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                long prevDp = 0, postDp = 0;
                if(j > 0){
                    prevDp = dp[i - 1][j - 1];
                }
                if (j + 1 < dp[i].length) {
                    postDp = dp[i - 1][j + 1];
                }
                dp[i][j] = (prevDp + postDp) % 1000000000;
            }
        }

        long total = 0;
        for (int i = 0; i < 10; i++) {
            total = (total + dp[n][i]) % 1000000000;
        }
        System.out.println(total);

        br.close();
    }
}