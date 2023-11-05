import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        long[] dp = new long[101];
        dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2; dp[5] = 2;
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (dp[num] > 0) {
                sb.append(dp[num] + "\n");
                continue;
            }

            for (int i = 6; i <= num; i++) {
                if(dp[i] > 0){
                    continue;
                }

                dp[i] = dp[i - 5] + dp[i - 1];
            }
            sb.append(dp[num] + "\n");
        }

        System.out.println(sb);

        br.close();
    }
}
