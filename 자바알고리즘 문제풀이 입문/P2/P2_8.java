package P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2_8 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[n];
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            heap.add(new int[]{i, Integer.parseInt(stk.nextToken())});
        }

        int rk = 0;
        int beforeNum = -1;
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            int[] node = heap.poll();
            if (beforeNum != node[1]) {
                beforeNum = node[1];
                rank[node[0]] = n - heap.size();
                rk = n - heap.size();
            }else{
                rank[node[0]] = rk;
            }
        }

        for (int r : rank) {
            sb.append(r + " ");
        }

        System.out.println(sb);

        br.close();
    }
}