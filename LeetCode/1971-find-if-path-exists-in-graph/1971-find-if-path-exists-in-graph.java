class Solution {

    private boolean[] isVisited;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int nodeX = edge[0];
            int nodeY = edge[1];

            graph[nodeX].add(nodeY);
            graph[nodeY].add(nodeX);
        }

        isVisited = new boolean[n];

        return dfs(graph, destination, source);
    }

    private boolean dfs(List<Integer>[] graph, int to, int node) {
        isVisited[node] = true;
        if(node == to) {
            return true;
        }

        for(int neighbor : graph[node]) {
            if(isVisited[neighbor]) continue;

            boolean visitedTarget = dfs(graph, to, neighbor);
            if(visitedTarget) return visitedTarget;
        }

        return false;
    }


}