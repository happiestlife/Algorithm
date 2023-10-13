import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] nums = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

        br.close();
    }
}