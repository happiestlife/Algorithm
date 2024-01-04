import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;

    private static int m;

    private static int nums[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        nums = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(nums);

        int[] curNumIdxs = new int[m];
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            calc(rs, curNumIdxs, 0, i);
        }

        System.out.println(rs);

        br.close();
    }

    public static void calc(StringBuilder rs, int[] curNumIdxs, int cnt, int idx) {
        curNumIdxs[cnt] = idx;
        if(cnt == m - 1){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < curNumIdxs.length; i++) {
                sb.append(nums[curNumIdxs[i]] + " ");
            }
            rs.append(sb + "\n");
            curNumIdxs[cnt] = -1;
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            calc(rs, curNumIdxs, cnt + 1, i);
        }

        curNumIdxs[cnt] = -1;
    }
}