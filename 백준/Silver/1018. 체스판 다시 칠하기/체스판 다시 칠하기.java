import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // TODO: 풀이
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int startX = i;
                int startY = j;
                char startChar = board[startX][startY];
                // 한 행씩 검증
                char validChar1 = startChar;
                char validChar2 = getOppositeChar(startChar);
//                System.out.println(validChar1 + " <> "+ validChar2);

                int curResult1 = 0;
                int curResult2 = 0;
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 8; l++) {
                        char curChar1 = board[startX + k*2][startY + l];
                        char curChar2 = board[startX + k*2 + 1][startY + l];

                        if(l%2 == 0) {
//                            System.out.println(curChar1 + " & " + validChar1 + " >> " + (curChar1 != validChar1));
//                            System.out.println(curChar2 + " & " + validChar2 + " >> " + (curChar2 != validChar2));
                            if(curChar1 != validChar1) curResult1++;
                            if(curChar2 != validChar2) curResult1++;

                            if(curChar1 != validChar2) curResult2++;
                            if(curChar2 != validChar1) curResult2++;
                        }
                        else {
//                            System.out.println(curChar1 + " & " + validChar2 + " >> " + (curChar1 != validChar2));
//                            System.out.println(curChar2 + " & " + validChar1 + " >> " + (curChar2 != validChar1));
                            if(curChar1 != validChar2) curResult1++;
                            if(curChar2 != validChar1) curResult1++;

                            if(curChar1 != validChar1) curResult2++;
                            if(curChar2 != validChar2) curResult2++;
                        }
                    }
                }

//                System.out.println(result + ", " + curResult);
                result = Math.min(result, Math.min(curResult1, curResult2));
            }
        }
        System.out.println(result);

        br.close();
    }

    private static char getOppositeChar(char c) {
        if(c == 'B') return 'W';
        else return 'B';
    }
}
