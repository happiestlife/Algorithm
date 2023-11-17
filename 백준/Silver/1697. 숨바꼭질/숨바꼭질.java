import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final long INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());
        
        long[] visitCnt = new long[100001];
        Arrays.fill(visitCnt, INF);

        // 노드 위치
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visitCnt[start] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            int db = cur * 2;
            int plusOne = cur + 1;
            int minusOne = cur - 1;

            if(cur == end){
                break;
            }

            if (db <= 100000 && visitCnt[db] == INF) {
                q.add(db);
                visitCnt[db] = visitCnt[cur] + 1;
            }

            if (plusOne <= 100000 && visitCnt[plusOne] == INF) {
                q.add(plusOne);
                visitCnt[plusOne] = visitCnt[cur] + 1;
            }

            if(minusOne >= 0 && visitCnt[minusOne] == INF) {
                q.add(minusOne);
                visitCnt[minusOne] = visitCnt[cur] + 1;
            }
        }

        System.out.println(visitCnt[end]);

        br.close();
    }

}
