package P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toLowerCase().toCharArray();
        char x = br.readLine().toLowerCase().charAt(0);

        Arrays.sort(input);
        String s = new String(input);

        int count = 0;
        boolean isSame = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isSame && c != x)
                break;
            if(c == x) {
                if(!isSame)
                    isSame = true;
                count++;
            }
        }
        System.out.println(count);

        br.close();
    }
}