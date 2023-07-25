import java.util.*;

class Solution {
    public int solution(int n, int[][] road, int k) {
        // [i][0] : toNode, [i][1] : 시간
        List<int[]>[] graph = new List[n + 1];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 1. 그래프 그리기
        for(int i = 0; i < road.length; i++){
            int[] edge = road[i];
            int v1 = edge[0];
            int v2 = edge[1];
            int w = edge[2];
            
            graph[v1].add(new int[]{v2, w});
            graph[v2].add(new int[]{v1, w});
        }
        
        // 2. 다익스트라 알고리즘 사용
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        // [i][0] : node, [i][1] : 시간
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
            return e1[1] - e2[1]; 
        });
        pq.add(new int[]{1, 0});
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int node = edge[0];
            
            for(int i = 0; i < graph[node].size(); i++){
                int[] adj = graph[node].get(i);
                int to = adj[0];
                int w = adj[1];
                if(dist[to] > dist[node] + w){
                    dist[to] = dist[node] + w;
                    pq.add(new int[]{to, w});
                }
            }
        }
        
        int cnt = 0;
        for(int i = 1; i < dist.length; i++){
            if(dist[i] <= k)
                cnt++;
        }
        
        return cnt;
        
    }
}