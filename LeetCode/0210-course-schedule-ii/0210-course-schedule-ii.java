import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. 그래프 && 특정 수업별로 사전에 들어야 하는 수업 조건 만들기
        int[] preCourses = new int[numCourses];
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < prerequisites.length; i++){
            int[] prerequisite = prerequisites[i];
            int to = prerequisite[0], from = prerequisite[1];

            graph[from].add(to);
            preCourses[to]++;
        }  

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < preCourses.length; i++) {
            if(preCourses[i] == 0) q.add(i);
        }

        boolean[] isVisited = new boolean[numCourses];
        int[] result = new int[numCourses];
        int resultIdx = 0;
        while(!q.isEmpty()) {
            int curNode = q.poll();
            result[resultIdx++] = curNode;

            // 아직 방문하지 않았고 사전 강의를 모두 수강했다면 방문 가능
            for(int neighbor : graph[curNode]) {
                if(isVisited[neighbor] || --preCourses[neighbor] > 0) continue;

                q.add(neighbor);
                isVisited[curNode] = true;
            }
        }

        if(resultIdx < numCourses) result = new int[0];

        return result;
    }
}