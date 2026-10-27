class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int[] edge : edges) {
            int nodeX = edge[0];
            int nodeY = edge[1];
            graph[nodeX].add(nodeY);
            graph[nodeY].add(nodeX);
        }
        
        int[] nodeNeighbors = new int[n];
        for(int i = 0; i < graph.length; i++) {
            nodeNeighbors[i] = graph[i].size();
        }

        int removedCnt = 0;
        boolean[] isRemoved = new boolean[n];
        List<Integer> result = new ArrayList<>();
        while(true) {
            // 1. 현재 단계에서 잔여 Leaf 노드 제거
            List<Integer> curRemovedNodes = new ArrayList<>();
            for(int curNode = 0; curNode < graph.length; curNode++) {
                if(isRemoved[curNode]) continue;

                int curNodeNeighborCnt = nodeNeighbors[curNode];
                if(curNodeNeighborCnt <= 1) {
                    curRemovedNodes.add(curNode);
                }
            }

            // 2. 제거가 된 노드들이 정답인지 검증
            // - 이번 단계에서 모든 노드들이 제거된 경우
            if(removedCnt + curRemovedNodes.size() == n) {
                result = curRemovedNodes;
                break;
            } else {
                for(int removedNode : curRemovedNodes) {
                    removedCnt++;
                    isRemoved[removedNode] = true;

                    for(Integer removedNodeNeighbor : graph[removedNode]){
                        nodeNeighbors[removedNodeNeighbor] -= 1;
                    }
                }
            }
        }

        return result;
    }

    // public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    //     Set[] graph = new Set[n];
    //     for(int i = 0; i < graph.length; i++) {
    //         graph[i] = new HashSet<Integer>();
    //     }

    //     for(int[] edge : edges) {
    //         int nodeX = edge[0];
    //         int nodeY = edge[1];
    //         graph[nodeX].add(nodeY);
    //         graph[nodeY].add(nodeX);
    //     }

    //     int removedCnt = 0;
    //     boolean[] isRemoved = new boolean[n];
    //     List<Integer> result = new ArrayList<>();
    //     while(true) {
    //         // 1. 현재 단계에서 잔여 Leaf 노드 제거
    //         List<Integer> curRemovedNodes = new ArrayList<>();
    //         for(int curNode = 0; curNode < graph.length; curNode++) {
    //             if(isRemoved[curNode]) continue;
    //             Set<Integer> curNodeNeighbors = graph[curNode];

    //             int curNodeAliveNeighborCnt = 0;
    //             for(int neighbor : curNodeNeighbors) {
    //                 if(isRemoved[neighbor]) continue;

    //                 curNodeAliveNeighborCnt++;
    //             }

    //             if(curNodeAliveNeighborCnt <= 1) {
    //                 curRemovedNodes.add(curNode);
    //             }
    //         }

    //         // 2. 제거가 된 노드들이 정답인지 검증
    //         // - 이번 단계에서 모든 노드들이 제거된 경우
    //         if(removedCnt + curRemovedNodes.size() == n) {
    //             result = curRemovedNodes;
    //             break;
    //         } else {
    //             for(int removedNode : curRemovedNodes) {
    //                 removedCnt++;
    //                 isRemoved[removedNode] = true;
    //             }
    //         }
    //     }

    //     return result;
    // }
}