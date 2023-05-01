package P6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] horses = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < horses.length; i++) {
            horses[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(horses);
        int minDist = horses[0];
        int maxDist = horses[horses.length - 1] - horses[0];
        for (int i = 0; i < horses.length - 1; i++) {
            minDist = Math.min(minDist, horses[i + 1]);
        }


        int rs = 0;
        while (minDist <= maxDist) {
            int dist = (minDist + maxDist) / 2;

            int horseInHomeCnt = 1;
            int curPos = horses[0];
            for (int i = 1; i < horses.length; i++) {
                if (horses[i] >= curPos + dist) {
                    horseInHomeCnt++;
                    curPos = horses[i];
                }
            }

            // 마굿간에 들어간 말의 수가 넣으려는 말의 수보다 적으면
            if(horseInHomeCnt < m){
                maxDist = dist - 1;
            }
            else{
                rs = dist;
                minDist = dist + 1;
            }
        }

        System.out.println(rs);

        br.close();
    }
}
