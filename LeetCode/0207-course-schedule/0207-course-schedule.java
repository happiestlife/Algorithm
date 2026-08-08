import java.util.*;

class Solution {

    private boolean[] isVisited;

    private boolean[][] edges;

    private boolean[] isSearchedNode;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. 그래프 초기화
        isVisited = new boolean[numCourses];
        isSearchedNode = new boolean[numCourses];

        edges = new boolean[numCourses][numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];

            edges[from][to] = true;
        }

        // 2. dfs 수행 -> 사이클 확인 
        boolean canGraduate = true;
        for(int i = 0; i < numCourses; i++){
            if(isSearchedNode[i]) continue;

            if(hasCycle(i)) {
                canGraduate = false;
                break;
            }
        }

        return canGraduate;
    }

    private boolean hasCycle(int n) {
        isVisited[n] = true;
        isSearchedNode[n] = true;

        boolean[] nodeEdges = edges[n];
        for(int i = 0; i < nodeEdges.length; i++) {
            // edge가 없는 경우 continue;
            if(!nodeEdges[i]) continue; 

            // 탐색에서 이미 방문한 경우가 있으면 사이클 판정
            if(isVisited[i]) return true;
            else if (isSearchedNode[i]) continue;
            else {
                // 다음 이웃 노드들을 방문하면서 cycle을 찾은 경우 즉시 true 반환
                boolean findCycle = hasCycle(i);
                if(findCycle) return true;
            }
        } 

        // 이웃이 없는 경우 && 본인 및 자식들에서 cycle이 발견되지 않은 경우 false
        isVisited[n] = false;
        return false;
    }
}