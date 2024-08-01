import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] comps = br.readLine().split(" ");
        for(int i = 0; i < comps.length; i++) {
            arr[i] = Integer.parseInt(comps[i]);
        }

        int[] upDp = getAscendingDp(arr);
        int[] downDp = getDescendingDp(arr);

        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, upDp[i] + downDp[i]);
        }

        System.out.println(max - 1);

        br.close();
    }

    private static int[] getAscendingDp(int[] arr) {
        int[] dp = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            for(int j = 0; j < i; j++) {
                int prev = arr[j];

                if(cur > prev) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            dp[i]++;
        }

        return dp;
    }

    private static int[] getDescendingDp(int[] arr) {
        int[] dp = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            int cur = arr[i];
            for(int j = arr.length - 1; j > i; j--) {
                int prev = arr[j];

                if(cur > prev) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            dp[i]++;
        }

        return dp;
    }
}