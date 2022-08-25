import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean isNotPrim[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        isNotPrim = new boolean[m + 1];

        for (int i = 2; i <= m; i++) {
            if (isNotPrim[i] == false) {
                if(i >= n)
                    bw.write(i + "\n");

                int j = 1;
                while (i * j <= m) {
                    isNotPrim[i*j++] = true;
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
