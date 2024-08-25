import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        Integer[] sumXY = new Integer[N];
        Integer[] sumXZ = new Integer[N];
        Integer[] sumYZ = new Integer[N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int z = Integer.parseInt(line[2]);

            sumXY[i] = x + y;
            sumXZ[i] = x + z;
            sumYZ[i] = y + z;
        }

        Arrays.sort(sumXY, Collections.reverseOrder());
        Arrays.sort(sumXZ, Collections.reverseOrder());
        Arrays.sort(sumYZ, Collections.reverseOrder());

        int maxXY = 0, maxXZ = 0, maxYZ = 0;

        for (int i = 0; i < K; i++) {
            maxXY += sumXY[i];
            maxXZ += sumXZ[i];
            maxYZ += sumYZ[i];
        }

        int result = Math.max(maxXY, Math.max(maxXZ, maxYZ));
        System.out.println(result);
    }
}
