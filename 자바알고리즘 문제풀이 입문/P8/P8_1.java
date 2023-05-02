package P8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P8_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            sum += arr[i];
        }

        boolean isSuccess = false;
        for (int i = 1; i < n / 2; i++) {
            for (int j = 0; j < arr.length; j++) {
                isSuccess = dfs(sum, i, arr, 0, 1, arr[j]);
                if(isSuccess)
                    break;
            }
        }

        if(isSuccess)
            System.out.println("YES");
        else
            System.out.println("NO");
        br.close();
    }

    public static boolean dfs(int totalSum, int subCnt, int[] arr, int curIdx, int curSize, int curSum) {
        if(curSize == subCnt){
            return totalSum - curSum == curSum;
        }

        for (int i = curIdx + 1; i < arr.length; i++) {
            if(dfs(totalSum, subCnt, arr, i, curSize + 1, curSum + arr[i]))
                return true;
        }

        return false;
    }
}
