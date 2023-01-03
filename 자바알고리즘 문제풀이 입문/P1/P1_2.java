package P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        int diff = 'a' - 'A';
        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            if ('a' <= c && c <= 'z') {
                input[i] -= diff;
            }else{
                input[i] += diff;
            }
        }

        System.out.println(new String(input));

        br.close();
    }
}