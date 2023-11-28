import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int ladderCnt = Integer.parseInt(stk.nextToken());
        int snakeCnt = Integer.parseInt(stk.nextToken());

        int[] jumps = new int[101];
        for (int i = 0; i < ladderCnt + snakeCnt; i++) {
            stk = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            jumps[from] = to;
        }

        int[] dp = new int[101];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int cur = q.poll();

            for (int i = 1; i <= 6; i++) {
                int movePoint = cur + i;
                if(movePoint > 100) continue;

                // 아직 방문하지 않았으면 or 이전에 들어갔던 값보다 현재 위치에서 이동한 값이 작은 경우
                if(dp[movePoint] == 0 || dp[movePoint] > dp[cur] + 1){
                    dp[movePoint] = dp[cur] + 1;
                    // 사다리 / 뱀이 있다면 탄 후의 위치도 초기화
                    if(jumps[movePoint] != 0){
                        movePoint = jumps[movePoint];
                        if(dp[movePoint] == 0 || dp[movePoint] > dp[cur] + 1) dp[movePoint] = dp[cur] + 1;
                    }

                    q.add(movePoint);
                }
            }
        }

        System.out.println(dp[100]);

        br.close();
    }

}