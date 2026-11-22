import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[5001];
        Arrays.fill(dp, -1);
        dp[3] = dp[5] = 1;
        for(int i = 6; i <= n; i++) {
            int prev3 = 0, prev5 = 0;
            if(dp[i-3] > 0) prev3 = dp[i-3]+1;
            if(dp[i-5] > 0) prev5 = dp[i-5]+1;

            if(prev3 == 0 && prev5 == 0) {
                continue;
            } else if(prev3 == 0) {
                dp[i] = prev5;
            } else if(prev5 == 0) {
                dp[i] = prev3;
            } else {
                dp[i] = Math.min(prev3, prev5);
            }
        }

        System.out.println(dp[n]);

        br.close();
    }
}
