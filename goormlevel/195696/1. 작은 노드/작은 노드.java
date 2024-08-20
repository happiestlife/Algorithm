import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=1; i<=N; i++) {
            Collections.sort(graph[i]);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(K);
        visited[K] = true;
        int lastNode = K;
        int count = 1;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int next : graph[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    lastNode = next;
                    count++;
                    break;
                }
            }
        }

        System.out.println(count + " " + lastNode);
    }
}