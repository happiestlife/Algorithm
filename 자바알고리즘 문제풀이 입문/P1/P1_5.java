package P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        int fi = 0, li = input.length - 1;
        while (fi < li) {
            boolean isFrontAlphabet = isAlphabet(input[fi]);
            boolean isBackAlphabet = isAlphabet(input[li]);
            if(isFrontAlphabet && isBackAlphabet){
                char tmp = input[fi];
                input[fi] = input[li];
                input[li] = tmp;
                li--; fi++;
            }
            if(!isFrontAlphabet)
                fi++;
            if(!isBackAlphabet)
                li--;

        }
        System.out.println(new String(input));

        br.close();
    }

    public static boolean isAlphabet(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }
}