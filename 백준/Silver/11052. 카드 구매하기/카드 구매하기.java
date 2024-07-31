import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[1001];

        int n = Integer.parseInt(br.readLine());
        int[] cardPrices = new int[n];

        String[] comps = br.readLine().split(" ");
        for(int i = 0; i < cardPrices.length; i++) {
            cardPrices[i] = Integer.parseInt(comps[i]);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < cardPrices.length; j++) {
                int cardCnt = j + 1;
                if(i - cardCnt >= 0) dp[i] = Math.max(dp[i], dp[i - cardCnt] + cardPrices[j]);
            }
        }

        System.out.println(dp[n]);

        br.close();
    }
}