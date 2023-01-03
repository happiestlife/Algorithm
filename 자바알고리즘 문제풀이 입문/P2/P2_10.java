package P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class P2_10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 2][n + 2];
        boolean[][] isNotTop = new boolean[n + 2][n + 2];

        int[] fx = {-1, 0, 1, 0};
        int[] fy = {0, 1, 0, -1};


        for (int i = 1; i <= n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(isNotTop[i][j])
                    continue;

                int h = map[i][j];
                boolean isHigh = true;
                for (int k = 0; k < 4; k++) {
                    if(h <= map[i+fx[k]][j+fy[k]]){
                        isHigh = false;
                        break;
                    }
                }

                if(isHigh){
                    for (int k = 0; k < 4; k++) {
                        isNotTop[i+fx[k]][j+fy[k]] = true;
                    }
                    count++;
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}