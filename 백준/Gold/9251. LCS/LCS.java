
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine(), str2 = br.readLine();

        int max = 0;
        /**
         *  dp : 최장 부분 수열의 길이 (x : str1의 부분 집합 길이, y : str2의 부분 집합 길이)
         *  Ex) str1 = "ACAYKP", str2 = "CAPCAK", x = 2, y = 3 => comp1 = "AC", comp2 = "CAP" 
         *  
         *  dp 로직
         *  1. str1의 x번째 문자와 str2의 y번째 문자가 같다면, 해당 문자가 포함되기 전까지의 최고 길이 + 1
         *  Ex) str1 = "ACAYKP", str2 = "CAPCAK", x = 6, y = 3 => comp1 = "ACAYKP", comp2 = "CAP" 
         *      ("ACAYKP", "CAP")간 최장 부분 수열의 길이 = ("ACAYK", "CA")간 최장 부분 수열의 길이 + 1
         *      
         *  2. str1의 x번째 문자와 str2의 y번째 문자가 다르다면, (x-1, y)의 최장 부분 수열 길이와 (x, y-1)의 최장 부분 수열 길이의 최댓값
         *     (x-1, y) or (x, y-1)인 이유 : x 또는 y를 그대로 두고 나머지 부분 수열의 길이를 1 낮춘 값이 최장 부분 수열이 될 수 있는 후보이기 때문
         *  Ex) str1 = "ACAYKP", str2 = "CAPCAK", x = 4, y = 3 => comp1 = "ACAY", comp2 = "CAP" 
         *      ("ACA", "CAP") OR ("ACAY", "CA")의 최장 부분 수열의 길이 최댓값
         */
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int x = 1; x < dp.length; x++) {
            char c1 = str1.charAt(x - 1);
            for (int y = 1; y < dp[x].length; y++) {
                char c2 = str2.charAt(y - 1);
                if(c1 == c2){
                    dp[x][y] = dp[x - 1][y - 1] + 1;
                }else{
                    dp[x][y] = Math.max(dp[x - 1][y], dp[x][y - 1]);
                }

                max = Math.max(dp[x][y], max);
            }
        }

        System.out.println(max);

        br.close();
    }
}