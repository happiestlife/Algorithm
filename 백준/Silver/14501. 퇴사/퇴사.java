import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final int spanIdx = 0;
        final int costIdx = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int workDayLen = Integer.parseInt(br.readLine());
        int[][] consultations = new int[workDayLen + 1][2];
        for (int i = 1; i < consultations.length; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int span = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());

            consultations[i][spanIdx] = span;
            consultations[i][costIdx] = cost;
        }

        int prevMaxCost = 0;
        int[] dp = new int[consultations.length + 1];
        for (int i = 1; i < consultations.length; i++) {
            int startDay = i;
            int span = consultations[i][spanIdx];
            int cost = consultations[i][costIdx];

            // i일에 대한 최대 이익이 나오지 않은 경우, i-1까지의 최대 이익으로 설정
            dp[i] = Math.max(dp[i], prevMaxCost);
            // 현재 상담을 했을 때 그 상담의 종료기간이 일하는 마지막 날보다 이전이어야 한다.
            if(startDay + span - 1 <= workDayLen) {
                // 현재일에 들어온 상담을 할 경우, (현재일 + 상담에 걸린 시간) 날짜의 최대 이익을 설정
                dp[startDay + span] = Math.max(dp[startDay + span], dp[startDay] + cost);
            }
            prevMaxCost = Math.max(prevMaxCost, dp[i]);
        }

        int maxCost = 0;
        for (int cost : dp) {
            maxCost = Math.max(cost, maxCost);
        }
        System.out.println(maxCost);

        br.close();
    }
}
