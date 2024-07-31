import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++) dp[i] = dp[i-1] + dp[i - 2];

        System.out.println(dp[dp.length - 1]);

        br.close();
    }
}