package P10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        Integer[] coinTypes = new Integer[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < coinTypes.length; i++) {
            coinTypes[i] = Integer.parseInt(stk.nextToken());
        }

        int requestMoney = Integer.parseInt(br.readLine());
        int[] dp = new int[requestMoney + 1];
        for (int i = 0; i < coinTypes.length; i++) {
            dp[coinTypes[i]] = 1;
        }

        for (int i = 1; i <= requestMoney; i++) {
            for (int j = 0; j < coinTypes.length; j++) {
                int prevCoinIdx = i - coinTypes[j];

                if(prevCoinIdx >= 0 && dp[prevCoinIdx] > 0){
                    if(dp[i] == 0)
                        dp[i] = dp[prevCoinIdx] + 1;
                    else
                        dp[i] = Math.min(dp[prevCoinIdx] + 1, dp[i]);
                }
            }
        }

        System.out.println(dp[requestMoney]);

        br.close();
    }
}
