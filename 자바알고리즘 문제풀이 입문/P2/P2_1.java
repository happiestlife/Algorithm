package P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int beforeNum = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if (i == 0) {
                sb.append(num + " ");
            } else if(beforeNum < num) {
                sb.append(num + " ");
            }

            beforeNum = num;
        }

        System.out.println(sb);

        br.close();
    }
}