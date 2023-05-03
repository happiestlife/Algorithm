package P8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P8_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] types = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < types.length; i++) {
            types[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(types);

        int totalMoney = Integer.parseInt(br.readLine());

        boolean[] isVisited = new boolean[totalMoney + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(totalMoney);
        int cnt = 0;
        boolean isSuccess = false;
        int levelCnt = 0, curLevelCnt = 1, nextLevelCnt = 0;
        while (!q.isEmpty()) {
            int money = q.poll();
            levelCnt++;
            for (int i = 0; i < types.length; i++) {
                int restMoney = money - types[i];
                if(restMoney == 0) {
                    isSuccess = true;
                    break;
                }
                else if(restMoney < 0 || isVisited[restMoney])
                    continue;

                q.add(restMoney);
                isVisited[restMoney] = true;
                nextLevelCnt++;
            }
            if(isSuccess)
                break;

            if(levelCnt == curLevelCnt){
                cnt++;
                curLevelCnt = nextLevelCnt;
                nextLevelCnt = 0;
                levelCnt = 0;
            }
        }

        System.out.println(cnt + 1);

        br.close();
    }
}
