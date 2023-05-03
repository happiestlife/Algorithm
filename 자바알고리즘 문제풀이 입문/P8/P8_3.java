package P8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P8_3 {

    private static long maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] score = new int[n];
        int[] needTime = new int[n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(stk.nextToken());
            needTime[i] = Integer.parseInt(stk.nextToken());
        }

        dfs(m, score, needTime, -1, 0, 0);

        System.out.println(maxScore);

        br.close();
    }

    private static void dfs(int m, int[] score, int[] needTime, int curIdx, long curScoreSum, long curTimeSum) {
        if(curIdx == score.length - 1){
            maxScore = Math.max(maxScore, curScoreSum);
            return;
        }

        if(curTimeSum + needTime[curIdx+1] <= m) {
            dfs(m, score, needTime, curIdx + 1,
                    curScoreSum + score[curIdx+1], curTimeSum + needTime[curIdx+1]);
        }
        dfs(m, score, needTime, curIdx + 1, curScoreSum, curTimeSum);
    }
}
