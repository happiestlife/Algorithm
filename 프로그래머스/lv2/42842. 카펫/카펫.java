class Solution {
    
    static final int MAX = 2501;

    static boolean[][] isVisited = new boolean[MAX][MAX];
    
    static int rs[];
    
    public int[] solution(int brown, int yellow) {
        cmptSrch(3, 3, brown, yellow);
        return rs;
    }
    
    public static void cmptSrch(int x, int y, int brown, int yellow) {
        // map에 해당 건을 넣어서 중복으로 조사하는 것을 방지. x와 y가 바뀌어도 결과는 똑같기 때문에 역전시켜서도 넣어준다.
        isVisited[x][y] = true;
        isVisited[y][x] = true;

        // System.out.print(x + ", " + y  + ", " + brown + ", " + yellow);

        // 갈색 노란색 수 계산
        int brownCnt = 2 * (x + y - 2);
        int yellowCnt = x * y - brownCnt;

        // System.out.println(" >> " + brownCnt + ", " + yellowCnt);

        // 정답과 같다면 리턴
        if(yellowCnt > yellow){
            return;
        }
        else if (brownCnt == brown && yellowCnt == yellow) {
            if (y > x) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            rs = new int[]{x, y};
        }else {
            // x 또는 y를 하나 증가시켜서 탐색 실시
            // 이미 계산한 x와 y 건이면 pass

            if (x+1 < MAX && !isVisited[x+1][y]) {
                cmptSrch(x + 1, y, brown, yellow);
            }
            if (y+1 < MAX && !isVisited[x][y+1]) {
                cmptSrch(x, y + 1, brown, yellow);
            }
        }
    }
}