import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int MAX = 101;
    private static long[][][] dp = new long[MAX][MAX][MAX];

    private static final String FORMAT = "w(%d, %d, %d) = %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            long answer = recur(a, b, c);
            sb.append(String.format(FORMAT, a, b, c, answer));
        }

        System.out.println(sb);

        br.close();
    }

    public static long recur(int a, int b, int c){
        int idxA = a + 50;
        int idxB = b + 50;
        int idxC = c + 50;

        if(dp[idxA][idxB][idxC] != 0){
            return dp[idxA][idxB][idxC];
        }

        if(a <= 0 || b <= 0 || c <= 0){
            return dp[idxA][idxB][idxC] = 1;
        }
        else if (a > 20 || b > 20 || c > 20) {
            return dp[idxA][idxB][idxC] = recur(20, 20, 20);
        }
        else if (a < b && b < c) {
            return dp[idxA][idxB][idxC] = recur(a, b, c - 1) + recur(a, b - 1, c - 1) - recur(a, b - 1, c);
        }
        else{
            return dp[idxA][idxB][idxC] = recur(a - 1, b, c) + recur(a - 1, b - 1, c) + recur(a - 1, b, c - 1) - recur(a - 1, b - 1, c - 1);
        }
    }
}