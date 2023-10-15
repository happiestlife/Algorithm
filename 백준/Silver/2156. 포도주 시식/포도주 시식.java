import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[10001];
        int[] nums = new int[10001];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = nums[1];
        dp[2] = dp[1] + nums[2];
        for (int i = 3; i <= n; i++) {
            long case1 = dp[i - 3] + nums[i] + nums[i - 1];
            long case2 = dp[i - 2] + nums[i];
            long case3 = dp[i - 1];
            dp[i] = Math.max(case3, Math.max(case1, case2));
        }

        System.out.println(dp[n]);

        br.close();
    }
}