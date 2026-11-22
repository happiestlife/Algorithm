import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int max = 0;
        int[] arr = new int[t];
        for(int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        for(int i = 4; i <= max; i++) {
            for(int j = 1; j <= 3; j++) {
                dp[i] = (int)(((long)dp[i] + dp[i-j]) % 1000000009);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(dp[arr[i]]);
            if(i < arr.length-1) sb.append("\n");
        }
        System.out.println(sb.toString());
        
        br.close();
    }

}
