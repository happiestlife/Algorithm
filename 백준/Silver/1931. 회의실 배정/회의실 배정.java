import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        StringTokenizer stk;

        // [0] : 시작 시간, [1] : 종료 시간
        List<int[]> schedules = new ArrayList<>();
        while (c-- > 0) {
            stk = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());

            schedules.add(new int[]{s, e});
        }


        Collections.sort(schedules, (s1, s2) -> {
            if (s1[1] == s2[1]) {
                return s1[0] - s2[0];
            }
            return s1[1] - s2[1];
        });


        int cnt = 0;
        int lastScheduleEndTime = 0;
        for (int[] schedule : schedules) {
            int s = schedule[0];
            int e = schedule[1];
//            System.out.println(s + " ~ " + e);

            if (s >= lastScheduleEndTime) {
                cnt++;
                lastScheduleEndTime = e;
            }
        }

        System.out.println(cnt);

        br.close();
    }

}
