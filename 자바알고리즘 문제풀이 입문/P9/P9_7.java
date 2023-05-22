package P9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P9_7 {

    static int[] connectedIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());

        connectedIndex = new int[v + 1];
        for (int i = 0; i < connectedIndex.length; i++) {
            connectedIndex[i] = i;
        }

        int[][] graph = new int[e][3];
        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(br.readLine());

            int[] edge = graph[i];
            for (int j = 0; j < edge.length; j++) {
                edge[j] = Integer.parseInt(stk.nextToken());
            }
        }

        Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));

        int totalCost = 0;
        for (int i = 0; i < e; i++) {
            int[] edge = graph[i];

            int idx1 = find(edge[0]);
            int idx2 = find(edge[1]);

            if (idx1 != idx2) {
                if(idx1 > idx2){
                    connectedIndex[idx2] = idx1;
                }
                else{
                    connectedIndex[idx1] = idx2;
                }

                totalCost += edge[2];
            }
        }

        System.out.println(totalCost);

        br.close();
    }

    static int find(int node){
        if(connectedIndex[node] == node){
            return node;
        }

        return connectedIndex[node] = find(connectedIndex[node]);
    }
}
