package P9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P9_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // [0] : 시작 시간, [1] : 종료 시간
        int[][] attendTime = new int[n][2];
        StringTokenizer stk;
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            attendTime[i][0] = Integer.parseInt(stk.nextToken());
            attendTime[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(attendTime, Comparator.comparingInt(o -> o[0]));

        int max = 0;
        PriorityQueue<Integer> curPeople = new PriorityQueue<>();
        for (int i = 0; i < attendTime.length; i++) {
            int[] time = attendTime[i];

            while (!curPeople.isEmpty() && curPeople.peek() <= time[0]) {
                curPeople.poll();
            }
            curPeople.add(time[1]);

            max = Math.max(max, curPeople.size());
        }

        System.out.println(max);

        br.close();
    }
}
