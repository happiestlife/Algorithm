package P6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(stk.nextToken());
        }

        int[] copy = heights.clone();
        Arrays.sort(copy);
        int[] rs = new int[2];
        int rsIdx = 0;
        for (int i = 0; i < copy.length; i++) {
            if(copy[i] != heights[i])
                rs[rsIdx++] = i+1;
        }

        System.out.print(rs[0] + " " + rs[1]);

        br.close();
    }
}
