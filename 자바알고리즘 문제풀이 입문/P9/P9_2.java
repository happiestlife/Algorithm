package P9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P9_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // [0] : start time, [1] : end time
        int[][] roomsTime = new int[n][2];
        StringTokenizer stk;
        int lastFinishTime = 0;
        for (int i = 0; i < roomsTime.length; i++) {
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());

            roomsTime[i][0] = s;
            roomsTime[i][1] = e;

            lastFinishTime = Math.max(lastFinishTime, e);
        }

        Arrays.sort(roomsTime, Comparator.comparingInt(r -> r[1]));

        int cnt = 0;
        boolean[] isUsed = new boolean[lastFinishTime + 1];
        for (int i = 0; i < roomsTime.length; i++) {
            int[] usedRoom = roomsTime[i];

            boolean canUse = true;
            for (int j = usedRoom[0]; j < usedRoom[1]; j++) {
                if(isUsed[j]){
                    canUse = false;
                    break;
                }
            }

            if (canUse) {
                cnt++;
                int useStart = usedRoom[0];
                int useEnd = usedRoom[1];
                if(useStart == useEnd)
                    useEnd++;
                Arrays.fill(isUsed, useStart, useEnd, true);
            }
        }

        System.out.println(cnt);

        br.close();
    }
}
