import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;

    private static int m;

    private static StringBuilder rs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        int[] nums = new int[m];
        for (int i = 1; i <= n - m + 1; i++) {
            calc(nums, 0, i);
        }

        System.out.println(rs);

        br.close();
    }

    public static void calc(int[] nums, int cnt, int num) {
        nums[cnt] = num;
        if(cnt == m - 1){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                sb.append(nums[i] + " ");
            }
            rs.append(sb + "\n");
            nums[cnt] = 0;
            return;
        }

        for (int i = num + 1; i <= n; i++) {
            calc(nums, cnt + 1, i);
        }

        nums[cnt] = 0;
    }
}