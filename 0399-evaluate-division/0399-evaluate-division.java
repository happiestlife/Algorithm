import java.util.*;

class Edge {
    Node to;
    double weight;

    public Edge(Node to, double weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Node {
    String var;
    List<Edge> neighbors;

    public Node(String var) {
        this.var = var;
        this.neighbors = new ArrayList<>();
    }
}

class Solution {

    private static final double FAIL_VALUE = -1.0;

    private Map<String, Boolean> isVisited;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 1. 방향 그래프 생성
        Map<String, Node> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            List<String> edge = equations.get(i);
            String fromVar = edge.get(0);
            String toVar = edge.get(1);

            double value = values[i];

            if(!graph.containsKey(fromVar)) graph.put(fromVar, new Node(fromVar));
            if(!graph.containsKey(toVar)) graph.put(toVar, new Node(toVar));

            Node fromNode = graph.get(fromVar);
            Node toNode = graph.get(toVar);

            // 정방향 Edge 추가
            double forwardValue = value;
            List<Edge> neighbors = fromNode.neighbors;
            neighbors.add(new Edge(toNode, forwardValue));

            // 역방향 Edge 추가
            double reverseValue = 1 / value;
            neighbors = toNode.neighbors;
            neighbors.add(new Edge(fromNode, reverseValue));
        }

        // for(String key: graph.keySet()) {
        //     Node n = graph.get(key);
        //     System.out.println("var " + n.var);

        //     for(Edge e : n.neighbors) {
        //         System.out.println("to " + e.to.var + " weight " + e.weight);
        //     }
        // }

        // 2. query별로 계산하기 
        // 2-1. 시작 노드에서 dfs 시작
        // 2-2. 초기값을 1로 시작하고 dfs를 통해 edge weight를 곱하면서 이동
        // 2-3. 만약 목표 인덱스를 발견하면 return 결과
        // 2-4. 목표 인덱스를 발견하지 못하면 return -1
        double[] result = new double[queries.size()];
        for(int i = 0; i < result.length; i++) {
            List<String> query = queries.get(i);
            String fromVar = query.get(0);
            String toVar = query.get(1);

            Node startNode = graph.get(fromVar);
            if(startNode == null) {
                result[i] = FAIL_VALUE;
            } else if (fromVar.equals(toVar)) {
                result[i] = (double)(1.0);
            } else {
                isVisited = new HashMap<>();
                result[i] = dfs(graph, toVar, startNode, (double)1.0);
            }
            // System.out.println((i+1) + ". result : " + result[i]);
        }
        
        return result;
    }

    private double dfs(Map<String, Node> graph, String targetNodeVar, Node node, double curResult) {
        isVisited.put(node.var, true);

        for(Edge edge : node.neighbors){
            String toVar = edge.to.var;
            // System.out.println("neighbor to var " + toVar);
            if(isVisited.get(toVar) != null && isVisited.get(toVar)) continue;

            // 이웃 노드가 targetNode였다면 결과 반환
            if(toVar.equals(targetNodeVar)) {
                // System.out.println("find targetVar origin: " + node.var);
                return curResult * edge.weight;
            }

            // System.out.println("search to node : " + edge.to.var);
            double dfsResult = dfs(graph, targetNodeVar, edge.to, curResult * edge.weight);
            // dfs 탐색 결과 TargetNode를 발견하지 못한 경우 다른 dfs 탐색 시작
            if(dfsResult == FAIL_VALUE) continue;
            else return dfsResult;
        }

        return FAIL_VALUE;
    }
}