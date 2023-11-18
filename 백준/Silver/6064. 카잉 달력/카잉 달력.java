import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        while (t-- > 0) {
            stk = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            int rs = -1;

            int gcd = getGcd(n, m);
            int lcm = gcd * (n / gcd) * (m / gcd);

            Set<Integer> candidates = new HashSet<>();
            while (x <= lcm) {
                candidates.add(x);
                x += n;
            }

            while(y <= lcm){
                if(candidates.contains(y)){
                    rs = y;
                    break;
                }
                y += m;
            }

            sb.append(rs + "\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static int getGcd(int x, int y) {
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        int n = 0;
        while (y != 0) {
            n = x % y;
            x = y;
            y = n;
        }

        return x;
    }

}
