package P3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        int r = 0, l = 0;
        int sum = 0, rs = 0;
        for (; r < nums.length; r++) {
            sum += nums[r];
            if(sum == n) rs++;
            while(sum >= n){
                sum -= nums[l++];
                if(sum == n) rs++;
            }
        }

        System.out.println(rs);
    }
}
