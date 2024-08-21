import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long bCount = 0, operationCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'b') {
                bCount++;
            } else {
                operationCount = (operationCount + bCount) % 1000000007;
                bCount = (bCount * 2) % 1000000007;
            }
        }
        System.out.println(operationCount);
    }
}