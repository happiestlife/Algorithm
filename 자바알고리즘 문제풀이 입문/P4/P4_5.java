package P4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P4_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        Integer[] nums = new Integer[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        int sum = 0;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                for (int l = j + 1; l < nums.length; l++) {
                    sum += nums[l];
                    treeSet.add(sum);
                    sum -= nums[l];
                }
                sum -= nums[j];
            }
            sum -= nums[i];
        }

        int rs = -1;
        int cnt = 0;
        for (Integer num : treeSet) {
            cnt++;
            if(cnt == k){
                rs = num;
                break;
            }
        }
        System.out.println(rs);

        br.close();
    }
}