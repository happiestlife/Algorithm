package P3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int s = 1, e = 1;
        int sum = s, rs = 0;
        while(e < n){
            // 정답과 같을 때
            if(sum == n){
                rs++;
                sum += ++e;
            }
            // 작을 때
            else if(sum < n){
                sum += ++e;
            }
            // 클 때
            else{
                if(s == e){
                    sum += ++e;
                }else{
                    sum -= s++;
                }
            }
        }

        System.out.println(rs);

        br.close();
    }
}
