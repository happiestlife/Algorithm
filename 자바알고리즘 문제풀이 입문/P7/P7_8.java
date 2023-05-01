package P7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P7_8 {

    private static final int[] move = {1, 5, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());

        // [0] : 현위치, [1] : 단계
        boolean[] isVisited = new boolean[10001];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        int level = 0;
        int curLevelCnt = 1, nextLevelCnt = 0, levelCnt = 0;
        while (!q.isEmpty()) {
            int point = q.poll();
            levelCnt++;
            boolean isSuccess = false;
            for (int i = 0; i < move.length; i++) {
                int movePoint = point + move[i];
                if (isVisited[movePoint] ||
                        (point > e && move[i] > 0) ||
                        (point < e && move[i] < 0)) {
                    continue;
                }
                else if(movePoint == e) {
                    isSuccess = true;
                    break;
                }

                q.add(movePoint);
                isVisited[movePoint] = true;
                nextLevelCnt++;
            }

            if(isSuccess)
                break;

            if(levelCnt == curLevelCnt){
                level++;
                curLevelCnt = nextLevelCnt;
                levelCnt = 0;
                nextLevelCnt = 0;
            }
        }

        System.out.println(level+1);

        br.close();
    }

}
