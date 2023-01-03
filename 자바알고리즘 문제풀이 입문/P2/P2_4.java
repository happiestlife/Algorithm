package P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int t1 = 0, t2 = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(t2 + " ");
            int tmp = t1;
            t1 = t2;
            t2 = t1 + tmp;
        }
        System.out.println(sb);

        br.close();
    }
}