import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i < dp.length; i++) {
            int num = 1;
            while(num * num <= i) {
                dp[i] = Math.min(dp[i], dp[i - num * num] + 1);
                num++;
            }
        }

        System.out.println(dp[n]);

        br.close();
    }
}