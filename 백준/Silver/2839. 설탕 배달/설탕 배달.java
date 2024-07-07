import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int weight = Integer.parseInt(br.readLine());
        int[] dp = new int[weight + 1];
        Arrays.fill(dp, -1);
        if(dp.length > 3) dp[3] = 1;
        if(dp.length > 5) dp[5] = 1;

        for (int i = 6; i < dp.length; i++) {
            int cnt3 = dp[i - 3];
            int cnt5 = dp[i - 5];

            if(cnt3 == -1 && cnt5 == -1) {
                dp[i] = -1;
            }
            else {
                if(cnt3 == -1) cnt3 = 5001;
                if(cnt5 == -1) cnt5 = 5001;

                dp[i] = Math.min(cnt3, cnt5) + 1;
            }
        }

        System.out.println(dp[dp.length - 1]);

        br.close();
    }
}