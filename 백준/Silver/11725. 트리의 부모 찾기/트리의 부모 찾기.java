import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer stk;
        for (int i = 1; i < graph.length - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(stk.nextToken());
            int v2 = Integer.parseInt(stk.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        boolean[] isVisited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        // key : node, value : parent node number
        Map<Integer, Integer> parentNodeByNode = new HashMap<>();
        q.add(1);
        isVisited[1] = true;
        while (!q.isEmpty()) {
            int curNode = q.poll();

            for (int i = 0; i < graph[curNode].size(); i++) {
                int adj = graph[curNode].get(i);

                if(!isVisited[adj]){
                    q.add(adj);
                    parentNodeByNode.put(adj, curNode);
                    isVisited[adj] = true;
                }
            }
        }

        StringBuilder rs = new StringBuilder();
        for (int i = 2; i < graph.length; i++) {
            rs.append(parentNodeByNode.get(i) + "\n");
        }
        System.out.println(rs);

        br.close();
    }
}
