package P6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        long sum = 0;
        int[] nums = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
            sum += nums[i];
        }

        long s = 1, e = sum;
        long mid = 0;
        long rs = 0;
        while(s <= e){
            mid = (s + e) / 2;

            // 몇개의 DVD가 나오는지 판단
            int dvdCnt = 1;
            int curDvdStorage = 0;
            for (int i = 0; i < nums.length; i++) {
                if(curDvdStorage + nums[i] > mid){
                    dvdCnt++;
                    curDvdStorage = 0;
                }
                curDvdStorage += nums[i];
            }

            // dvd 개수가 만들려수는 dvd 수보다 많다면
            if(dvdCnt > m){
                s = mid + 1;
            }
            // m개 이하라면
            else{
                rs = mid;
                e = mid - 1;
            }
        }

        System.out.println(rs);

        br.close();
    }
}
