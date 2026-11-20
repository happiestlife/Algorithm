import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

class Node {
    int num;
    int delaySum;

    public Node(int num, int delaySum) {
        this.num = num;
        this.delaySum = delaySum;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        int maxLen = 0;
        int maxIdx = 0;
        String[] longAscNums = new String[n];
        int[] dp = new int[n];
        for(int i = 0; i < dp.length; i++) {
            int curNum = nums[i];
            int maxPrevLen = 0;
            StringBuilder maxLenPrevString = new StringBuilder();
            for(int j = i-1; j >= 0; j--) {
                if(nums[j] < curNum) {
                    if(dp[j] > maxPrevLen) {
                        maxPrevLen = dp[j];
                        maxLenPrevString = new StringBuilder(longAscNums[j]);
                    }
                }
            }
            maxPrevLen++;
            maxLenPrevString.append(" ").append(curNum);

            dp[i] = maxPrevLen;
            longAscNums[i] = maxLenPrevString.toString();

            if(dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        System.out.println(dp[maxIdx]);
        System.out.println(longAscNums[maxIdx].trim());


        br.close();
    }
}
