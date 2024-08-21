import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            int[][] grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(row[j]);
                }
            }
            int minWaste = Integer.MAX_VALUE;
            for (int i = 0; i <= N - K; i++) {
                for (int j = 0; j <= N - K; j++) {
                    int waste = 0;
                    for (int x = i; x < i + K; x++) {
                        for (int y = j; y < j + K; y++) {
                            waste += grid[x][y];
                        }
                    }
                    minWaste = Math.min(minWaste, waste);
                }
            }
            sb.append(minWaste).append("\n");
        }
        System.out.print(sb.toString());
    }
}