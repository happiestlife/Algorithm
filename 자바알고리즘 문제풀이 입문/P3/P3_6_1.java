package P3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3_6_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] nums = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        int l = 0, r = 0;
        int changeCnt = 0;
        int oneCntMax = nums[0];
        for (; r < nums.length; r++) {
            if(nums[r] == 0){
                if(changeCnt < m){
                    changeCnt++;
                }else{
                    while(nums[l] == 1){
                        l++;
                    }
                    l++;
                }
            }

            oneCntMax = Math.max(oneCntMax, r - l + 1);
        }

        System.out.println(oneCntMax);
    }


}
