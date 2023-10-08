import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] dp = new int[500001];
    private static boolean[] isDisabled = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int targetChannel = Integer.parseInt(br.readLine());
        int disabledBtnCnt = Integer.parseInt(br.readLine());

        if(disabledBtnCnt > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            while (stk.hasMoreTokens()) {
                isDisabled[Integer.parseInt(stk.nextToken())] = true;
            }
        }

        System.out.println(calc(targetChannel, disabledBtnCnt));

        br.close();
    }

    public static long calc(int target, int disabledBtnCnt){
        if(disabledBtnCnt == 10){
            return Math.abs(100 - target);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 1000000; i++) {
            if(!canMake(i)){
                continue;
            }

            int pushBtnCnt = String.valueOf(i).length();
            pushBtnCnt += Math.abs(target - i);

            min = Math.min(min, pushBtnCnt);
        }

        min = Math.min(min, Math.abs(target - 100));

        return min;
    }

    public static boolean canMake(int channel){
        String channelStr = String.valueOf(channel);
        for (int i = 0; i < channelStr.length(); i++) {
            char c = channelStr.charAt(i);
            if (isDisabled[c - '0'])
                return false;
        }

        return true;
    }
}
