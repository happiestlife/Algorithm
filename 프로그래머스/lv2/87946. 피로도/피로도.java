class Solution {
    
    static int rs;
    static boolean isVisited[];
    
    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            cdfs(dungeons, k - dungeons[i][1], i, 1);
        }
        
        return rs;
    }
    
    public static void cdfs(int[][] dungeons, int fatigue, int visitNode, int visitedCnt) {
        isVisited[visitNode] = true;

        boolean isVisit = false;
        for (int i = 0; i < isVisited.length; i++) {
            // 방문하지 않았고
            if(!isVisited[i] &&
            // 현재 피로도가 최소 피로도 이상일 때
                    fatigue >= dungeons[i][0]) {
                cdfs(dungeons, fatigue - dungeons[i][1], i, visitedCnt + 1);
                isVisit = true;
            }
        }

        // 더 이상 다른 동굴을 방문하지 못한다면 최종 도착지임으로 방문한 동굴 수 계산
        if (!isVisit) {
            rs = Math.max(visitedCnt, rs);
        }

        isVisited[visitNode] = false;
    }
}