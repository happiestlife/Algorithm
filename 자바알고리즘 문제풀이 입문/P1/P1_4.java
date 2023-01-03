package P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            char[] chars = br.readLine().toCharArray();

            int charsLen = chars.length;
            int length = charsLen / 2;
            int j = 0;
            while (j < length) {
                char tmp = chars[j];
                chars[j] = chars[charsLen - 1 - j];
                chars[charsLen - 1 - j] = tmp;
                j++;
            }

            sb.append(new String(chars) + "\n");
        }
        System.out.println(sb);

        br.close();
    }
}