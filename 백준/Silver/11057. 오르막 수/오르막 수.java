import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[10];
        int[] curDigitDp = new int[dp.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            // 0으로 시작하는 n자리 수는 1밖에 없음 -> 제외
            for(int j = 0; j < dp.length; j++) {
                int prevDigitUpNumberCnt = 0;
                for (int k = 0; k <= j; k++) {
                    prevDigitUpNumberCnt = (prevDigitUpNumberCnt + dp[k]) % 10007;
                }

                curDigitDp[j] = prevDigitUpNumberCnt;
            }

            dp = curDigitDp;
            curDigitDp = new int[dp.length];
        }

        int sum = 0;
        for(int num : dp) {
            sum = (sum + num) % 10007;
        }

        System.out.println(sum);

        br.close();
    }

}