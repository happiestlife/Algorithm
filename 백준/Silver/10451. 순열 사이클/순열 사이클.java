import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            // graph 생성
            int[] graph = new int[n + 1];
            String[] edge = br.readLine().split(" ");
            for (int i = 0; i < edge.length; i++) {
                int from = i + 1;
                int to = Integer.parseInt(edge[i]);

                graph[from] = to;
            }

            int count = 0;
            boolean[] isVisited = new boolean[n + 1];
            for (int i = 1; i < graph.length; i++) {
                if(isVisited[i]) continue;

                int startNode = i;
                int curNode = i;
                while(!isVisited[graph[curNode]]) {
                    isVisited[graph[curNode]] = true;
                    if(graph[curNode] == startNode){
                        count++;
                        break;
                    }

                    curNode = graph[curNode];
                }
            }


            System.out.println(count);

        }

        br.close();
    }

}