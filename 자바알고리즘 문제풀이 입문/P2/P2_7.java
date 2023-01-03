package P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2_7 {

    static final int CORRECT = 1;
    static final int WRONG = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int rs = 0;
        int score = 0;
        for (int i = 0; i < n; i++) {
            int test = Integer.parseInt(stk.nextToken());
            switch (test) {
                case WRONG:
                    score = 0;
                    break;
                case CORRECT:
                    score += 1;
                    rs += score;
                    break;
            }
        }

        System.out.println(rs);

        br.close();
    }
}