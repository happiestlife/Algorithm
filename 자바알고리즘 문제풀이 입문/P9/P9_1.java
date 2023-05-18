package P9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 0 : 키, 1 : 몸무게
        List<int[]> players = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            players.add(new int[]{height, weight});
        }

        Collections.sort(players, ((o1, o2) -> o2[0] - o1[0]));

        int cnt = players.size();
        for (int i = 1; i < players.size(); i++) {
            int w = players.get(i)[1];
            for (int j = i-1; j >= 0; j--) {
                if (w < players.get(j)[1]) {
                    cnt--;
                    break;
                }
            }
        }

        System.out.println(cnt);

        br.close();
    }
}
