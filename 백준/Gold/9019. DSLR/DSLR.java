import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final char[] operations = {'D', 'S', 'L', 'R'};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(stk.nextToken());
            int target = Integer.parseInt(stk.nextToken());

            String[] dp = new String[10000];
            Queue<Integer> q = new LinkedList<>();
            q.add(origin);
            dp[origin] = "";
            boolean isSuccess = false;
            while (!q.isEmpty()) {
                int num = q.poll();

                for (char oper : operations) {
                    int nextNum = cal(oper, num);
                    if(nextNum == target){
                        sb.append(dp[num] + oper + "\n");
                        isSuccess = true;
                        break;
                    }
                    else if(dp[nextNum] == null){
                        dp[nextNum] = dp[num] + oper;
                        q.add(nextNum);
                    }
                }

                if(isSuccess)
                    break;
            }
        }

        System.out.println(sb);

        br.close();
    }

    private static int cal(char type, int num) {
        if (type == 'D') {
            return (num * 2) % 10000;
        } else if (type == 'S') {
            if (num == 0) {
                return 9999;
            } else {
                return num - 1;
            }
        } else {
            int d1 = num / 1000;
            int d2 = (num % 1000) / 100;
            int d3 = (num % 100) / 10;
            int d4 = num % 10;
            if (type == 'L') {
                return d2 * 1000 + d3 * 100 + d4 * 10 + d1;
            } else {
                return d4 * 1000 + d1 * 100 + d2 * 10 + d3;
            }
        }
    }

    private static class Point{
        int curNum;
        String cmd;

        public Point(int curNum, String cmd) {
            this.curNum = curNum;
            this.cmd = cmd;
        }
    }
}