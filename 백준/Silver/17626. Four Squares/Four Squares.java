import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(findNumCnt(n));

        br.close();
    }

    public static int findNumCnt(int n) {
        int maxNum = 1;
        while (maxNum * maxNum <= n) {
            maxNum++;
        }
        maxNum--;
        
        int curSum = 0;
        int rs = 5;
        for (int i = maxNum; i >= 0; i--) {
            int squareNum1 = i * i;
            curSum += squareNum1;
            if(curSum == n){
                rs = Math.min(rs, 1);
            }
            for (int j = i; j >= 0; j--) {
                int squareNum2 = j * j;
                curSum += squareNum2;
                if(curSum == n){
                    rs = Math.min(rs, 2);
                }
                for (int k = j; k >= 0; k--) {
                    int squareNum3 = k * k;
                    curSum += squareNum3;
                    if(curSum == n){
                        rs = Math.min(rs, 3);
                    }
                    for (int l = k; l >= 0; l--) {
                        int squareNum4 = l * l;
                        curSum += squareNum4;
                        if(curSum == n){
                            rs = Math.min(rs, 4);
                        }
                        curSum -= squareNum4;
                    }
                    curSum -= squareNum3;
                }
                curSum -= squareNum2;
            }
            curSum -= squareNum1;
        }

        return rs;
    }
}