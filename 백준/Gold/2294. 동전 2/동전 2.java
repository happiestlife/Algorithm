import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[100001];
        Arrays.fill(dp, -1);
        for(int i = 0; i < nums.length; i++) dp[nums[i]] = 1;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                int prev = i - nums[j];

                if(prev < 0 || dp[prev] == -1) continue;

                if(dp[i] == -1) dp[i] = dp[prev] + 1;
                else dp[i] = Math.min(dp[i], dp[prev] + 1);
            }
        }

        System.out.println(dp[m]);
        br.close();
    }
}
