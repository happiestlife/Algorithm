import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];
        Arrays.fill(dp, -1);
        dp[2] = dp[5] = 1;
        for (int i = 0; i <= n; i++) {
            int prev2 = 0, prev5 = 0;
            if(i-2 >= 0 && dp[i-2] > 0) prev2 = dp[i-2];
            if(i-5 >= 0 && dp[i-5] > 0) prev5 = dp[i-5];

            if(prev2 == 0 && prev5 == 0) {
                continue;
            } else if(prev2 == 0) {
                dp[i] = prev5 + 1;
            } else if(prev5 == 0) {
                dp[i] = prev2 + 1;
            } else {
                dp[i] = Math.min(prev2, prev5) + 1;
            }
        }
        System.out.println(dp[n]);
        br.close();
    }

}
