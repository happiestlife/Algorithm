import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] comps = br.readLine().split(" ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(comps[i]);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] < nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[dp.length - 1]);

        br.close();
    }
}