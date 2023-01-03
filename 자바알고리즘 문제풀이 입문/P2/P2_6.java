package P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2_6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = 0;
            String s = stk.nextToken();
            for (int j = s.length() - 1; j >= 0; j--) {
                num = num * 10 + Character.getNumericValue(s.charAt(j));
            }

            a[i] = num;
            if(max < num)
                max = num;
        }

        boolean[] isNotPrime = new boolean[max+1];
        for (int i = 2; i < isNotPrime.length; i++) {
            if(isNotPrime[i])
                continue;
            for (int j = 2; i * j < isNotPrime.length; j++) {
                isNotPrime[i * j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int num : a) {
            if(!isNotPrime[num] && num != 1){
                sb.append(num + " ");
            }
        }

        System.out.println(sb);

        br.close();
    }

}