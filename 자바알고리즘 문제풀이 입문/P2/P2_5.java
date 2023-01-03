package P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[n+1];

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isNotPrime[i]) {
                continue;
            }

            count++;
            for (int j = 2; i * j <= n; j++) {
                isNotPrime[i * j] = true;
            }
        }

        System.out.println(count);

        br.close();
    }
}