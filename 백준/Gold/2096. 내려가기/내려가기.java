import java.io.*;
import java.util.StringTokenizer;

public class Main {
    
    static int n;

    static int arr[];
    static int minDp[][];
    static int maxDp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[3];
        minDp = new int[2][3];
        maxDp = new int[2][3];

        StringTokenizer stk;
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[j] = Short.parseShort(stk.nextToken());

                if(j == 0){
                    minDp[1][j] = Math.min(minDp[0][0], minDp[0][1]) + arr[j];
                    maxDp[1][j] = Math.max(maxDp[0][0], maxDp[0][1]) + arr[j];
                }
                else if (j == 1) {
                    minDp[1][j] = Math.min(minDp[0][0], Math.min(minDp[0][1], minDp[0][2])) + arr[j];
                    maxDp[1][j] = Math.max(maxDp[0][0], Math.max(maxDp[0][1], maxDp[0][2])) + arr[j];
                }
                else {
                    minDp[1][j] = Math.min(minDp[0][1], minDp[0][2]) + arr[j];
                    maxDp[1][j] = Math.max(maxDp[0][1], maxDp[0][2]) + arr[j];
                }
            }

            for (int j = 0; j < 3; j++) {
                minDp[0][j] = minDp[1][j];
                maxDp[0][j] = maxDp[1][j];
            }
        }

        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, maxDp[1][i]);
            min = Math.min(min, minDp[1][i]);
        }

        System.out.println(max + " " + min);

        bw.flush();
        br.close();
        bw.close();
    }
}
