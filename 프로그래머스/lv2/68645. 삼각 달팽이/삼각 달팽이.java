class Solution {
//     public int[] solution(int n) {
//         int[][] map = new int[n][n];

//         // 0,0부터 시작하는 역직각삼각형을 그릴 것
//         int x = 0, y = 0;
//         int num = 1;
//         while(true){
//             // 1. 세로 줄 채우기
//             for (int i = 0; i < n; i++) {
//                 map[x++][y] = num++;
//             }
//             x--; y++;
//             n--;
//             if(n < 1)
//                 break;

//             // 2. 가로 줄 채우기
//             for (int i = 0; i < n; i++) {
//                 map[x][y++] = num++;
//             }
//             x--; y -= 2;
//             n--;
//             if(n < 1)
//                 break;

//             // 3. 대각선 채우기
//             for (int i = 0; i < n; i++) {
//                 map[x--][y--] = num++;
//             }
//             x += 2; y++;
//             n--;
//             if(n < 1)
//                 break;
//         }

//         int rsIdx = 0;
//         int[] rs = new int[num-1];
//         for (int i = 0; i < map.length; i++) {
//             for (int j = 0; j <= i; j++) {
//                 rs[rsIdx++] = map[i][j];
//             }
//         }
//         return rs;
//     }
     public int[] solution(int n) {
        int[][] map = new int[n][n];

        int x = 0, y = 0;
        int num = 1;
        while(n > 0){

            for (int i = 0; i < 3; i++) {
                // number 찍기
                for (int j = 0; j < n; j++) {
                    // 0 : 새로줄 이동, 1 : 가로줄 이동, 2 : 대각선 이동
                    switch (i){
                        case 0:
                            map[x++][y] = num++;
                            break;
                        case 1:
                            map[x][y++] = num++;
                            break;
                        case 2:
                            map[x--][y--] = num++;
                            break;
                    }
                }
                // 한칸 더 이동한 것들에 대해서 원점으로 복귀시킨 후 다음 칸으로 이동
                n--;
                if(n < 1)
                    break;

                switch (i){
                    case 0:
                        x--;
                        y++;
                        break;
                    case 1:
//                        y--;
//                        x--; y--;
                        x--; y -= 2;
                        break;
                    case 2:
//                        x++; y++;
//                        x++;
                        x += 2; y++;
                        break;
                }
            }
        }

        int rsIdx = 0;
        int[] rs = new int[num-1];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <= i; j++) {
                rs[rsIdx++] = map[i][j];
            }
        }
        return rs;
    }
}