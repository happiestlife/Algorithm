import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // [0] : adjacent node, [1] : dist
        List<int[]>[] graph = new List[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList();
        }

        StringTokenizer stk;
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());

            graph[from].add(new int[]{to, dist});
        }

        stk = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(stk.nextToken());
        int to = Integer.parseInt(stk.nextToken());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // [0] : node, [1] : dist
        PriorityQueue<int[]> q = new PriorityQueue<>((l1, l2) -> {
            return l1[1] - l2[1];
        });
        dist[from] = 0;
        q.add(new int[]{from, dist[from]});
        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int cur = curNode[0];
            int toCurDist = curNode[1];
            
            if(toCurDist > dist[cur]) continue;

            for (int[] adjNode : graph[curNode[0]]) {
                int adj = adjNode[0];
                int toAdjDist = adjNode[1];
                if(dist[adj] > dist[cur] + toAdjDist){
                    dist[adj] = dist[cur] + toAdjDist;
                    q.add(new int[]{adj, dist[adj]});
                }
            }
            
        }

        System.out.println(dist[to]);

        br.close();
    }
}