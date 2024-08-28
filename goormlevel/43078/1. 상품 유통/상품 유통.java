import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            BigInteger numerator = BigInteger.valueOf(R);
            BigInteger denominator = BigInteger.ONE;

            for (int i = 0; i < N; i++) {
                int taxRate = Integer.parseInt(st.nextToken());
                numerator = numerator.multiply(BigInteger.valueOf(100 - taxRate));
                denominator = denominator.multiply(BigInteger.valueOf(100));
            }

            BigInteger gcd = numerator.gcd(denominator);
            numerator = numerator.divide(gcd);
            denominator = denominator.divide(gcd);

            sb.append(numerator).append("/").append(denominator).append("\n");
        }

        System.out.print(sb.toString());
    }
}
