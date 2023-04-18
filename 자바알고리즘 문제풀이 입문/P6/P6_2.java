package P6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6_2 {
    /**
     * 버블 정렬
     * - 연속된 2개의 요소 비교
     * - 방법
     *  1) 첫번째 요소와 두번째 요소 비교, ..., 마지막 전 요소와 마지막 요소 비교
     *  2) 1회전에서 배열의 마지막 값에 가장 큰 값이 들어가게 됨
     *  3) 2회전에서부터는 마지막 전 요소, 마지막 전전 요소 .. 순서로 데이터가 들어간다.
     * - 시간복잡도 : O(N^2)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i] + " ");
        }

        System.out.println(sb);

        br.close();
    }
}
