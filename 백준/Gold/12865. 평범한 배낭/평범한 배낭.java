import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int WEIGHT = 0, VALUE = 1;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int[][] products = new int[N + 1][2];
        for (int i = 1; i < products.length; i++) {
            stk = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(stk.nextToken());
            int V = Integer.parseInt(stk.nextToken());
            products[i][WEIGHT] = W;
            products[i][VALUE] = V;
        }

        dp = new int[N + 1][K + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(j >= products[i][WEIGHT]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - products[i][WEIGHT]] + products[i][VALUE]);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][K]);


        br.close();
    }
    
}
