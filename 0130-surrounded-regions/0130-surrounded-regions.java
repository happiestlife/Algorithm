import java.util.*;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public void solve(char[][] board) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        boolean[][] notConvertPoints = new boolean[board.length][board[0].length];

        List<Point> oPoints = getOPoints(board);
        for(Point p : oPoints) {
            // System.out.println(p.x + ", " + p.y + " >> " + board[p.x][p.y]);

            if(isVisited[p.x][p.y]) continue;
            List<Point> notSurroundPoints = bfs(board, isVisited, p);

            for(Point notSurroundPoint : notSurroundPoints) {
                notConvertPoints[notSurroundPoint.x][notSurroundPoint.y] = true;
            }
        }

        for(int x = 0; x < board.length; x++) {
            for(int y = 0; y < board[x].length; y++) {
                if(board[x][y] == 'X' || notConvertPoints[x][y]) continue;

                board[x][y] = 'X';
            }
        }
    }

    private List<Point> getOPoints(char[][] board) {
        List<Point> oPoints = new ArrayList<>();
        int[] xEdge = {0, board.length-1};
        int[] yEdge = {0, board[0].length-1};

        for(int i = 0; i < xEdge.length; i++) {
            int x = xEdge[i];
            for(int y = 0; y < board[x].length; y++) {
                if(board[x][y] == 'O'){
                    oPoints.add(new Point(x, y));
                }
            }
        }


        for(int i = 0; i < yEdge.length; i++) {
            int y = yEdge[i];
            for(int x = 0; x < board.length; x++) {
                if(board[x][y] == 'O'){
                    oPoints.add(new Point(x, y));
                }
            }
        }

        return oPoints;
    }

    private List<Point> bfs(char[][] board, boolean[][] isVisited, Point startPoint) {
        List<Point> oPoints = new ArrayList<>();

        final int[] dx = { 0, 1, 0, -1};
        final int[] dy = {-1, 0, 1,  0};

        Queue<Point> q = new LinkedList<>();
        q.add(startPoint);
        isVisited[startPoint.x][startPoint.y] = true;
        while(!q.isEmpty()) {
            Point p = q.poll();
            
            oPoints.add(p);

            for(int i = 0; i < dx.length; i++) {
                int fx = p.x + dx[i];
                int fy = p.y + dy[i];

                // 변에 위치했다면 탈출안해도 됨
                if(
                    !(
                        (0 <= fx && fx < board.length) 
                    && (0 <= fy && fy < board[fx].length)
                    )
                ) {
                    continue;
                } else if(isVisited[fx][fy] || board[fx][fy] == 'X') continue;

                q.add(new Point(fx, fy));
                isVisited[fx][fy] = true; 
            }
        }

        return oPoints;
    }
}

// class Solution {
//     public void solve(char[][] board) {
//         boolean[][] isVisited = new boolean[board.length][board[0].length];
//         for(int x = 0; x < board.length; x++) {
//             for(int y = 0; y < board[x].length; y++) {
//                 if(isVisited[x][y]) continue;
                
//                 char c = board[x][y];
//                 if(c == 'X') continue;

//                 List<Point> convertPoints = bfs(board, isVisited, new Point(x, y));
//                 for(Point p : convertPoints) {
//                     board[p.x][p.y] = 'X';
//                 }
//             }
//         }
//     }

//     private List<Point> bfs(char[][] board, boolean[][] isVisited, Point startPoint) {
//         List<Point> convertPoints = new ArrayList<>();

//         final int[] dx = { 0, 1, 0, -1};
//         final int[] dy = {-1, 0, 1,  0};

//         boolean needConvert = true;
//         Queue<Point> q = new LinkedList<>();
//         q.add(startPoint);
//         while(!q.isEmpty()) {
//             Point p = q.poll();
//             convertPoints.add(p);
//             isVisited[p.x][p.y] = true;

//             for(int i = 0; i < dx.length; i++) {
//                 int fx = p.x + dx[i];
//                 int fy = p.y + dy[i];

//                 // 변에 위치했다면 탈출안해도 됨
//                 if(
//                     !(
//                         (0 <= fx && fx < board.length) 
//                     && (0 <= fy && fy < board[fx].length)
//                     )
//                 ) {
//                     needConvert = false;
//                     continue;
//                 } else if(isVisited[fx][fy] || board[fx][fy] == 'X') continue;

//                 q.add(new Point(fx, fy));
//             }
//         }

//         if(!needConvert) {
//             convertPoints.clear();
//         }

//         return convertPoints;
//     }

// }