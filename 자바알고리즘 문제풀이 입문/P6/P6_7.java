package P6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P6_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[][] points = new Integer[n][2];
        StringTokenizer stk;
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            Integer x = Integer.parseInt(stk.nextToken());
            Integer y = Integer.parseInt(stk.nextToken());

            points[i][0] = x;
            points[i][1] = y;
        }

        Arrays.sort(points, (o1, o2) -> {
            int xCompare = o1[0] - o2[0];
            if(o1[0].intValue() == o2[0].intValue()){
                return o1[1] - o2[1];
            }else{
                return xCompare;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i][0] + " " + points[i][1] + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}
