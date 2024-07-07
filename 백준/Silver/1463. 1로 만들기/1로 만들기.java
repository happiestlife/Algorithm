import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        final int MAX = 1000001;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, MAX);
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            int div3 = i % 3 == 0 ? dp[i / 3] : MAX;
            int div2 = i % 2 == 0 ? dp[i / 2] : MAX;
            int min1 = dp[i - 1];

            dp[i] = Math.min(Math.min(div3, div2), min1) + 1;

            int a = 10;
        }

        System.out.println(dp[dp.length - 1]);

        br.close();
    }
}