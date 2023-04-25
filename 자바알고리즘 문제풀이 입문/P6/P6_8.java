package P6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6_8 {
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

        Arrays.sort(nums);
        int s = 0, e = nums.length - 1;
        int mid = 0;
        while (s <= e) {
            mid = (s + e) / 2;
            if(nums[mid] == m){
                break;
            }
            else if(nums[mid] > m){
                e = mid - 1;
            }
            else if(nums[mid] < m){
                s = mid + 1;
            }
        }

        System.out.println(mid+1);

        br.close();
    }
}
