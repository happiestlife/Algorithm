import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] comps = br.readLine().split(" ");
        int n = Integer.parseInt(comps[0]);
        int k = Integer.parseInt(comps[1]);

        int[] coinValues = new int[n];
        for(int i = 0; i < n; i++) coinValues[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[k + 2];
        dp[1] = 1;
        for(int i = 0; i < coinValues.length; i++) {
            for(int j = 1; j < dp.length; j++) {
                if(j - coinValues[i] >= 0) dp[j] += dp[j - coinValues[i]];
            }
        }

        System.out.println(dp[dp.length - 1]);

        br.close();
    }
}