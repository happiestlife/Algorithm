import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

class Node {
    int num;
    int delaySum;

    public Node(int num, int delaySum) {
        this.num = num;
        this.delaySum = delaySum;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(stk.nextToken());

        StringBuilder result = new StringBuilder();
        for (int t = 0; t < T; t++) {
            stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());

            int[] delays = new int[n];
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                delays[i] = Integer.parseInt(stk.nextToken());
            }

            List<Integer>[] graph = new List[n];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            int[] needPreCnt = new int[n];
            for (int i = 0; i < k; i++) {
                stk = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(stk.nextToken())-1;
                int to = Integer.parseInt(stk.nextToken())-1;
                graph[from].add(to);
                needPreCnt[to]++;
            }
            // 1. 사전 건물이 필요없는 건물부터 짓기 시작
            // 해당 건물이 필요한 건물들에서 필요한 건물 개수 -1

            // 2. 다음 건물들 중 사전에 필요한 건물이 0이라면 다음 건설 대상 건물로 추가

            int end = Integer.parseInt(br.readLine().trim())-1;

            int[] nodeDelays = new int[n];
            Queue<Node> q = new ArrayDeque<>();
            for(int i = 0; i < needPreCnt.length; i++) {
                if(needPreCnt[i] == 0) {
                    q.add(new Node(i, delays[i]));
                    nodeDelays[i] = delays[i];
                }
            }
            while(!q.isEmpty()) {
                Node cur = q.poll();
                if(cur.num == end) break;

                for(int neighbor : graph[cur.num]) {
                    // 해당 노드 방문처리
                    needPreCnt[neighbor]--;
                    nodeDelays[neighbor] = Math.max(nodeDelays[neighbor], cur.delaySum + delays[neighbor]);
                    if(needPreCnt[neighbor] > 0) continue;

                    q.add(new Node(neighbor, nodeDelays[neighbor]));
                }
            }

            result.append(nodeDelays[end]);
            if(t <= T-2) result.append("\n");
        }
        System.out.println(result.toString());

        br.close();
    }
}
