package P6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6_1 {
    /**
     * 선택 정렬
     * - 제자리 정렬 알고리즘의 하나
     * - 방법
     *  1) 주어진 배열의 최솟값 구하기 (전체 탐색)
     *  2) 첫번째 요소와 바꾸기
     *  3) 첫번째 요소를 제외한 나머지 요소중 최솟값 찾기 (전체 탐색)
     *  4) 두전째 요소와 바꾸기
     *  5) ... 반복
     * - 시간 복잡도 : O(n^2)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i+1; j < nums.length; j++) {
                minIdx = nums[minIdx] > nums[j] ? j : minIdx;
            }
            int tmp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i] + " ");
        }

        System.out.println(sb);

        br.close();
    }
}
