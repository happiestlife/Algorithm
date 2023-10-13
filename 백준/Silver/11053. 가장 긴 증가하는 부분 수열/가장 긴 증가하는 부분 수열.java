import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] nums = new int[N + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        /**
         * dp는 해당 지점까지의 최대 길이를 지칭할 필요는 없다.
         * 여기서는 해당 지점을 포함한 최대 길이를 의미
         */
        int[] dp = new int[N + 1];
        for (int i = 1; i < dp.length; i++) {
            int maxLen = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    maxLen = Math.max(maxLen, dp[j] + 1);
                }
            }
            dp[i] = maxLen;
        }

        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);

        br.close();
    }
}