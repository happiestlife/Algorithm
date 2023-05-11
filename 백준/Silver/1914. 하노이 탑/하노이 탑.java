import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static int n;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        if(n <= 20) {
            hanoi(n, 1, 2, 3);
        }

        BigInteger cnt = new BigInteger(String.valueOf(1));

        for (int i = 0; i < n - 1; i++) {
            cnt = cnt.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));
        }


        System.out.println(cnt);
        if(n <= 20)
            System.out.println(sb);


        br.close();
    }

    public static void hanoi(int level, int from, int temp, int to) {
        if(level > 1) {
            hanoi(level - 1, from, to, temp);
        }

        sb.append(from + " " + to + "\n");

        if(level > 1) {
            hanoi(level - 1, temp, from, to);
        }
    }
}
