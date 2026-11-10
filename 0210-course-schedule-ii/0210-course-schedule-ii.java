class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. 그래프 && 특정 수업별로 사전에 들어야 하는 수업 조건 만들기
        List<Integer>[] preCourses = new List[numCourses];
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            preCourses[i] = new ArrayList<>();
        }

        for(int i = 0; i < prerequisites.length; i++){
            int[] prerequisite = prerequisites[i];
            int to = prerequisite[0], from = prerequisite[1];

            graph[from].add(to);
            preCourses[to].add(from);
        }  

        // 2. 모든 노드를 방문하면서 수강 가능한지 확인
        List<Integer> resultPath = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if(isVisited(resultPath, i) || !visitedPreCourse(preCourses, resultPath, i)) continue;

            List<Integer> searchResult = dfs(graph, preCourses, i, resultPath, new ArrayList<>());
            // System.out.println("i " + i + ", " + searchResult.size());
            if(searchResult.size() == 0) {
                resultPath.clear();
                break;
            }
        }

        // System.out.println("result " + resultPath.size() + " : " + numCourses);
        if(resultPath.size() != numCourses) resultPath.clear();

        int[] result = new int[resultPath.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = resultPath.get(i);
        }
        return result;
    }

    private List<Integer> dfs(List<Integer>[] graph, List<Integer>[] preCourses, int node, List<Integer> resultPath, List<Integer> curPath) {
        resultPath.add(node);
        curPath.add(node);

        List<Integer> neighbors = graph[node];
        for(int neighbor : neighbors) {
            // 사이클이 있다면 불가능
            if(curPath.size() > 0 && isVisited(curPath, neighbor)) {
                return new ArrayList<>(resultPath);
            }

            // 사전 강의를 모두 수강한 경우만 넘어갈 수 있음
            if(isVisited(resultPath, neighbor) || !visitedPreCourse(preCourses, resultPath, neighbor)) continue;

            List<Integer> pathResult = dfs(graph, preCourses, neighbor, resultPath, curPath);
            // 자식 노드에서 사이클이 발견된 경우는 즉시 리턴
            if(pathResult.size() == 0) {
                return new ArrayList<>(pathResult);
            } 
            // 그렇지 않은 경우 전부 더해주기
            else {
                curPath.addAll(pathResult);
            }
        }

        curPath.remove(curPath.size()-1);
        return new ArrayList<>(resultPath);
    }
    
    private boolean isVisited(List<Integer> path, int node) {
        return path.stream().anyMatch(n -> n == node);
    }

    private boolean visitedPreCourse(List<Integer>[] preCourses, List<Integer> resultPath, int node) {
        boolean isVisitPreCourses = true;

        // System.out.println("node " + node + " preCourse ");
        for(int preCourse : preCourses[node]) {
            // System.out.print(preCourse + " " + isVisited(resultPath, preCourse) + " ");
            if(!isVisited(resultPath, preCourse)) {
                isVisitPreCourses = false;
                break;
            }
        }
        System.out.println();

        return isVisitPreCourses;
    }

    // public int[] findOrder(int numCourses, int[][] prerequisites) {
    //     // 1. 그래프 && 특정 수업별로 사전에 들어야 하는 수업 조건 만들기
    //     List<Integer>[] preCourses = new List[numCourses];
    //     List<Integer>[] graph = new List[numCourses];
    //     for(int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //         preCourses[i] = new ArrayList<>();
    //     }

    //     for(int i = 0; i < prerequisites.length; i++){
    //         int[] prerequisite = prerequisites[i];
    //         int to = prerequisite[0], from = prerequisite[1];

    //         graph[from].add(to);
    //         preCourses[to].add(from);
    //     }

    //     // 2. cycle이 존재하는지 확인, 있다면 빈 문자열 반환
    //     boolean hasCycle = searchCycle(graph);
    //     // System.out.println("has cycle " + hasCycle);
    //     if(hasCycle) return new int[]{};

    //     // 2. 그래프를 BFS로 탐색 (DFS도 되지만 시간이 더 오래 걸릴것)
    //     // 특정 노드 방문 조건: 이전 노드가 모두 방문이 된 상태인지 체크 필요. 안되었다면 return false
    //     int[] result = new int[numCourses];
    //     int resultIdx = 0;
    //     boolean[] isVisited = new boolean[numCourses];
    //     for(int i = 0; i < numCourses; i++) {
    //         if(isVisited[i] || preCourses[i].size() >= 1) continue;

    //         Queue<Integer> q = new LinkedList<>();
    //         q.add(i);
    //         while(!q.isEmpty()) {
    //             int curNode = q.poll();
    //             result[resultIdx++] = curNode;
    //             isVisited[curNode] = true;

    //             List<Integer> neighbors = graph[curNode];
    //             for(int neighbor : neighbors) {
    //                 // 방문하려는 노드가 필요로 하는 이전 방문 노드를 모두 방문했다면 방문 가능
    //                 boolean isVisistedPreCourses = true;
    //                 for(int preCourse : preCourses[neighbor]) {
    //                     if(!isVisited[preCourse]) {
    //                         isVisistedPreCourses = false;
    //                         break;
    //                     }
    //                 }

    //                 if(!isVisistedPreCourses) continue;

    //                 q.add(neighbor);
    //             }
    //         }
    //     }

    //     return result;
    // }

    // private boolean searchCycle(List<Integer>[] graph) {
    //     // 모든 노드를 시작지점을 지정하고 출발 필요
    //     for(int i = 0; i < graph.length; i++) {
    //         boolean[] isVisited = new boolean[graph.length];

    //         if(dfs(graph, isVisited, i)) return true;
    //     }

    //     return false;
    // }

    // private boolean dfs(List<Integer>[] graph, boolean[] isVisited, int node) {
    //     isVisited[node] = true;
    
    //     List<Integer> neighbors = graph[node];
    //     for(int neighbor : neighbors) {
    //         if(isVisited[neighbor]) return true;

    //         boolean hasCycle = dfs(graph, isVisited, neighbor);
    //         if(hasCycle) return true;
    //     }

    //     isVisited[node] = false;
    //     return false;
    // }
}