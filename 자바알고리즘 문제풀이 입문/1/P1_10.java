import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1_10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        String s = stk.nextToken();
        char t = stk.nextToken().charAt(0);

        ArrayList<Integer> ind = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == t)
                ind.add(i);
        }

        int dist[] = new int[s.length()];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        for (Integer i : ind) {
            q.add(i);
            dist[i] = 0;
        }

        while (!q.isEmpty()) {
            /**
             * 1. 큐에서 하나의 인덱스가져오기
             * 2. 인덱스의 값이 0 이상이면 continue
             * 3. 0이면 인덱스 +1, -1에 대한 값을 dist[ind]의 값에서 일을 더한 값으로 초기화
             */

            Integer i = q.poll();

            if(i > 0 && dist[i-1] == -1){
                push(q, dist, i, -1);
            }
            if (i < s.length() - 1 && dist[i+1] == -1) {
                push(q, dist, i, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : dist) {
            sb.append(i + " ");
        }
        System.out.println(sb);

        br.close();
    }

    public static void push(Queue<Integer> q, int[] dist, int ind, int diff) {
        dist[ind + diff] = dist[ind]+1;
        q.add(ind + diff);
    }
}