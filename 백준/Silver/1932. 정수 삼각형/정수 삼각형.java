import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int triangle[];
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        triangle = new int[n * (n + 1) / 2 + 1];
        dp = new int[triangle.length];

        int count = 1;
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[count++] = Integer.parseInt(stk.nextToken());
            }
        }

        dp(1, 1);
        System.out.println(dp(1, 1));

        br.close();
    }

    public static int dp(int ind, int depth) {
        /**
         * 반환조건
         *  - 삼각형의 아랫변에 도달한다.
         */

        if (ind + depth > dp.length - 1) {
            return dp[ind] = triangle[ind];
        }else if(dp[ind] != 0)
            return dp[ind];


        return dp[ind] = Math.max(dp(ind + depth, depth + 1),
                            dp(ind + depth + 1, depth + 1)) + triangle[ind];
    }
}
