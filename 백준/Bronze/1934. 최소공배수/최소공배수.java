import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder rs = new StringBuilder();
        while(n-- > 0){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            long num1 = Long.parseLong(stk.nextToken());
            long num2 = Long.parseLong(stk.nextToken());
            if(num1 % num2 == 0 || num2 % num1 == 0){
                if(num1 % num2 == 0){
                    rs.append(num1 + "\n");
                }
                else{
                    rs.append(num2 + "\n");
                }

                continue;
            }

            long n1 = num1, n2 = num2;
            while(true){
                if(n1 == n2){
                    rs.append(n1 + "\n");
                    break;
                }
                else if(n1 > n2){
                    n2 += num2;
                }
                else {
                    n1 += num1;
                }
            }
        }

        System.out.println(rs.toString());

        br.close();
    }
}