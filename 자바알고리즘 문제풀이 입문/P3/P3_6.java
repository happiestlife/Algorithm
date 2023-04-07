package P3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class P3_6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] nums = new int[n];
        List<Integer> zeroIdx = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
            // 0이 위치한 인덱스 구하기
            if (nums[i] == 0) {
                zeroIdx.add(i);
            }
        }

        // 1. 0..k번째 0인덱스 1로 채우기
        int len = zeroIdx.size() > k ? k : zeroIdx.size();
        for (int i = 0; i < len; i++) {
            nums[zeroIdx.get(i)] = 1;
        }

        // 2. 하나씩 채워가면서 가장 긴 1 부분 배열 길이 count
        int rs = 0;
        int loopLen = zeroIdx.size() - k + 1;
        // 0의 개수가 0을 1로 채울 수 있는 개수보다 적다면 배열의 길이가 정답
        if(zeroIdx.size() <= k) {
            rs = nums.length;
            loopLen = -1;
        }
        for (int i = 0; i < loopLen; i++) {
            // 2-1. 1 시작 / 종료 인덱스 찾기
            int s = zeroIdx.get(i);
            int e = zeroIdx.get(i + k - 1);
            while(s > 0 && nums[s-1] == 1){
                s--;
            }
            while (e < nums.length-1 && nums[e+1] == 1) {
                e++;
            }
            // 2-2. 길이 count
            int length = e - s + 1;
            rs = Math.max(rs, length);

            // 2-3. 기존의 i번째 0 인덱스를 1에서 0으로 바꾸고, i+1번째 0 인덱스를 1로 바꾸기
            if(i == loopLen-1)
                break;
            nums[zeroIdx.get(i)] = 0;
            nums[zeroIdx.get(i + k)] = 1;
        }

        System.out.println(rs);

        br.close();
    }

}
