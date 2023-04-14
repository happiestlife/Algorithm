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

        Arrays.sort(nums, Collections.reverseOrder());

        int sum = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        boolean isFound = false;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                sum += nums[j];
                for (int l = j + 1; l < nums.length; l++) {
                    sum += nums[l];
                    treeSet.add(sum);
                    if(treeSet.size() == k){
                        isFound = true;
                        break;
                    }
                    sum -= nums[l];
                }
                if(isFound)
                    break;
                sum -= nums[j];
            }
            if(isFound)
                break;
            sum -= nums[i];
        }
        int rs = treeSet.first();
        if(!isFound)
            rs = -1;
        System.out.println(rs);

        br.close();
    }
}
