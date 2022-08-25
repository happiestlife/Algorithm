import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /**
     * 이분탐색으로 해결
     */
    static int n, m;
    static int find[], arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        find = new int[m];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            find[i] = Integer.parseInt(stk.nextToken());
        }
        
        for (int i = 0; i < m; i++) {
            bw.write(bs(find[i]) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int bs(int find) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == find) {
                return 1;
            } else if (arr[mid] < find) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }
}
