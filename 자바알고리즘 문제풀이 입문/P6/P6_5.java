package P6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        boolean[] isSubmitted = new boolean[10000001];
        boolean isDuplicated = false;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if(isSubmitted[num]){
                isDuplicated = true;
                break;
            }else{
                isSubmitted[num] = true;
            }
        }

        if(isDuplicated){
            System.out.println("D");
        }else{
            System.out.println("U");
        }



        br.close();
    }
}
