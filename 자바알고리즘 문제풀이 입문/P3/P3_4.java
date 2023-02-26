package P3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P3_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        int[] nums;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        nums = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        int s = 0, e = 0;
        long sum = nums[s], rs = 0;
        while (true) {
            // 정답과 같거나 작은 경우
            if(sum <= m){
                if(sum == m)
                    rs++;

                if(e == nums.length-1)
                    break;
                sum += nums[++e];
            }
            // 큰 경우
            else{
                if(s == e) {
                    if(e == nums.length-1)
                        break;
                    sum += nums[++e];
                }else
                    sum -= nums[s++];
            }
        }

        System.out.println(rs);

        br.close();
    }
}
