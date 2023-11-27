import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final char RED = 'R';
    static final char BLUE = 'B';
    static final char GREEN = 'G';

    static int n;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int normal = 0, colorBlindness = 0;
        boolean[][] isVisited = new boolean[n][n];
        boolean[][] isVisitedColorBlind = new boolean[n][n];
        Queue<Point> q;
        for (int i = 0; i < isVisited.length; i++) {
            for (int j = 0; j < isVisited[i].length; j++) {
                if(!isVisited[i][j]) {
                    visitSameSection(isVisited, i, j, map, true);
                    normal++;
                }

                if(!isVisitedColorBlind[i][j]) {
                    visitSameSection(isVisitedColorBlind, i, j, map, false);
                    colorBlindness++;
                }

            }
        }

        System.out.println(normal + " " + colorBlindness);

        br.close();
    }

    static void visitSameSection(boolean[][] isVisited, int x, int y, char[][] map, boolean isNormal){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        isVisited[x][y] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int k = 0; k < dx.length; k++) {
                int fx = p.x + dx[k];
                int fy = p.y + dy[k];

                if ((0 <= fx && fx < n) &&
                        (0 <= fy && fy < n) &&
                        !isVisited[fx][fy] &&
                        isSameColor(isNormal, map, fx, fy, p)) {
                    q.add(new Point(fx, fy));
                    isVisited[fx][fy] = true;
                }
            }
        }
    }

    static boolean isSameColor(boolean isNormal, char[][] map, int fx, int fy, Point curPoint) {
        char curPointColor = map[curPoint.x][curPoint.y];
        if(isNormal){
            return map[fx][fy] == curPointColor;
        }
        else{
            boolean isCurPointRedOrGreen = curPointColor != BLUE;
            return (isCurPointRedOrGreen && (map[fx][fy] != BLUE)) || (!isCurPointRedOrGreen && map[fx][fy] == curPointColor);
        }
    }

}

