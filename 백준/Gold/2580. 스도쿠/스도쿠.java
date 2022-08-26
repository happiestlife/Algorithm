import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int map[][] = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int empty = 0;
        StringTokenizer stk;
        for (int i = 0; i < 9; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 0)
                    empty++;
            }
        }

        boolean isSuccess = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(map[i][j] == 0)
                    if (dfs(i, j, empty)) {
                        isSuccess = true;
                        break;
                    }
            }

            if(isSuccess)
                break;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean dfs(int x, int y, int empty) {
        /**
         * 1. check
         *  - 빈칸에 들어갈 수 있는 수배열 찾고 넣기
         *  * 만약 모든 빈칸을 채웠다면 true를 리턴하기
         * 2. 순회할 수 있는 곳 순회 && 갈 수 있는가
         *  - 모든 map 조회 후 들어갈 수 있는 곳 가기
         *  - 만약 자식 dfs()에서 true 리턴 시 답을 찾았기 때문에 무조건적 리턴
         * 3. checkout
         */

//        for (int[] ints : map) {
//            for (int i : ints) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
        // 들아갈 수 있는 수배열 찾기
        boolean[] nums = findNum(x, y);
        if(nums == null)
            return false;
//        System.out.println(x + ", " + y);
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i])
//                System.out.print(i + " ");
//        }
//        System.out.println();


        // 찾은 수를 하나씩 넣어보기
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]) {
                // check
                map[x][y] = i;
                empty--;

                // 빈칸을 모두 채웠다면 성공표시 반환
                if(empty == 0)
                    return true;

                boolean isFail = false;
                // 아직 빈칸을 못채웠다면 dfs를 통해 모든 map을 처음붙 순회하며 빈칸을 채우기
                for (int j = 0; j < 9; j++) {
                    for (int k = 0; k < 9; k++) {
                        if(map[j][k] == 0) {
                            if (dfs(j, k, empty)) {
                                return true;
                            } else {
                                isFail = true;
                                break;
                            }
                        }
                    }
                    if(isFail)
                        break;
                }

                // 만약 해당 수로 모든 빈칸을 채우지 못했다면 빈칸 수 원상복구(하나를 넣어서 dfs 했기 때문에 +1)
                empty++;
                map[x][y] = 0;
            }
        }

        return false;
    }

    public static boolean[] findNum(int x, int y) {
        boolean isNotUsed[] = new boolean[10];
        Arrays.fill(isNotUsed, true);
        isNotUsed[0] = false;

        // 가로 열과 세로열은 불가
        for (int i = 0; i < 9; i++) {
            isNotUsed[map[x][i]] = isNotUsed[map[i][y]] = false;
        }

        int sectionX = (x/3) * 3;
        int sectionY = (y/3) * 3;
        for (int i = sectionX; i < sectionX + 3; i++) {
            for (int j = sectionY; j < sectionY + 3; j++) {
                isNotUsed[map[i][j]] = false;
            }
        }

        for (int i = 0; i < isNotUsed.length; i++) {
            if(isNotUsed[i])
                return isNotUsed;
        }
        return null;
    }
}
