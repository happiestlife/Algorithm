package P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class P2_9 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] row = new Integer[n];
        Integer[] col = new Integer[n];
        int crs1 = 0, crs2 = 0;

        Arrays.fill(row, 0);
        Arrays.fill(col, 0);
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(stk.nextToken());
                row[i] += num;
                col[j] += num;
                if(j == i)
                    crs1 += num;
                else if(j == n - i - 1)
                    crs2 += num;
            }
        }

        Arrays.sort(row, Collections.reverseOrder());
        Arrays.sort(col, Collections.reverseOrder());
        int max1 = row[0] > col[0] ? row[0] : col[0];
        int max2 = crs1 > crs2 ? crs1 : crs2;

        System.out.println(max1 > max2 ? max1 : max2);

        br.close();
    }
}
