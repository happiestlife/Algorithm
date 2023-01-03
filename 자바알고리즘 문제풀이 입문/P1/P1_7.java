package P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1_7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toLowerCase();

        int i = 0;
        for (; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                break;
            }
        }

        if (i == str.length() / 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        br.close();
    }
}