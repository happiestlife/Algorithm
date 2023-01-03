package P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(stk.nextToken());
            if(max < height){
                count++;
                max = height;
            }
        }

        System.out.println(count);

        br.close();
    }
}