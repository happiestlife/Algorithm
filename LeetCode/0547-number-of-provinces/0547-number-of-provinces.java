class Solution {

    private boolean[] isVisited;
    
    public int findCircleNum(int[][] isConnected) {
        int nodeCnt = isConnected.length;
        isVisited = new boolean[nodeCnt];

        int result = 0;
        for(int i = 0; i < nodeCnt; i++) {
            if(isVisited[i]) continue;

            dfs(isConnected, i);
            result++;
        }

        return result;
    }

    private void dfs(int[][] isConnected, int node){
        isVisited[node] = true;

        int[] nodeEdge = isConnected[node];
        for(int i = 0; i < nodeEdge.length; i++){
            // 노드가 연결되어 있고
            if(nodeEdge[i] == 0 
            // 자기자신 노드가 아니고
                    || i == node 
            // 아직 방문하지 않은 경우
                    || isVisited[i]) continue;
            dfs(isConnected, i);
        }
    }


}