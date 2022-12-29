import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1_12 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        String str = br.readLine();
        int[] bn = new int[7];
        for (int i = 0; i < 7; i++) {
            bn[i] = (int)Math.pow(2, i);
        }

        char ch = 0;
        int ind = bn.length - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            /**
             * 1. 인덱스 == 0
             *  1) 문자열에 문자 만들어 붙이기
             *  2) ind, c = 초기화
             *
             * 2. 인덱스 > 0
             *  1) num에 인덱스에 해당하는 값 더하기
             *  2) 인덱스 하나 줄이기
             */
            char c = str.charAt(i);

            if (c == '#') {
                ch += bn[ind];
            }
            ind--;

            if (ind == -1) {
                sb.append(ch);
                ind = bn.length - 1;
                ch = 0;
            }
        }

        System.out.println(sb);

        br.close();
    }
}