import java.io.*;
import java.util.Arrays;

public class Main {

    static int n;
    static char map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], ' ');
        }

        recur(0, 0, n);

        for (char[] chars : map) {
            for (char c : chars) {
                bw.write(c);
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void recur(int x, int y, int size) {
        // 재귀조건 : 크기가 3
        if (size == 3) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (i == x + 1 && j == y + 1) continue;
                    else map[i][j] = '*';
                }
            }
            return;
        }

        int childSize = size / 3;
        for (int i = x/childSize; i < x/childSize + 3; i++) {
            for (int j = y/childSize; j < y/childSize + 3; j++) {
                if (i == x/childSize + 1 && j == y/childSize + 1) continue;
                recur(i * childSize, j * childSize, childSize);
            }
        }
    }
}
