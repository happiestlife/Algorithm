package P8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P8_14 {

    static final int EMPTY = 0;
    static final int HOUSE = 1;
    static final int PIZZA = 2;

    // 상, 우, 하, 좌
    private static final int[] fx = {-1, 0, 1,  0};
    private static final int[] fy = { 0, 1, 0, -1};


    static int n;
    static int m;

    // [0] : x, [1] : y
    static List<int[]> pizzaPoints = new LinkedList<>();
    static List<int[]> housePoints = new LinkedList<>();

    static int[][] map;

    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new int[n][n];
        for (int i = 0; i < map.length; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == HOUSE)
                    housePoints.add(new int[]{i, j});
                else if(map[i][j] == PIZZA) {
                    pizzaPoints.add(new int[]{i, j});
                    map[i][j] = EMPTY;
                }
            }
        }

        for (int i = 0; i < pizzaPoints.size(); i++) {
            findWholeCase(i, 1);
        }

        System.out.println(minDist);

        br.close();
    }

    static void findWholeCase(int idx, int pizzaCnt) {
        int[] pizzaPoint = pizzaPoints.get(idx);
        map[pizzaPoint[0]][pizzaPoint[1]] = PIZZA;

        if(pizzaCnt == m){
            calMinDist();
            map[pizzaPoint[0]][pizzaPoint[1]] = EMPTY;
            return;
        }

        for (int i = idx + 1; i < pizzaPoints.size(); i++) {
            findWholeCase(i, pizzaCnt+1);
        }

        map[pizzaPoint[0]][pizzaPoint[1]] = EMPTY;
    }

    static void calMinDist() {
        int dist = 0;

        boolean[][] isVisited = new boolean[n][n];
        // [0] : x, [1] : y, [2] : 거리
        Queue<int[]> q = new LinkedList<>();
        for (int[] housePoint : housePoints) {
            q.add(new int[]{housePoint[0], housePoint[1], 0});
            isVisited[housePoint[0]][housePoint[1]] = true;

            while (!q.isEmpty()) {
                int[] node = q.poll();
                if(map[node[0]][node[1]] == PIZZA){
                    dist += Math.abs(node[0] - housePoint[0]) + Math.abs(node[1] - housePoint[1]);
                    break;
                }

                for (int i = 0; i < fx.length; i++) {
                    int dx = node[0] + fx[i];
                    int dy = node[1] + fy[i];

                    if ((0 <= dx && dx < map.length)
                            && (0 <= dy && dy < map[0].length)
                            && !isVisited[dx][dy]){
                        q.add(new int[]{dx, dy, node[2] + 1});
                        isVisited[dx][dy] = true;
                    }
                }
            }

            // 초기화
            q.clear();
            for (int i = 0; i < isVisited.length; i++) {
                Arrays.fill(isVisited[i], false);
            }
        }

        minDist = Math.min(minDist, dist);
    }
}
