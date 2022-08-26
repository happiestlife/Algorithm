import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /**
     * 최소 자음 2개, 모음 1개
     * 구성문자들은 오름차순
     */
    static int l, c;
    static char[] alphabets;
    static int selectedInd[];
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        l = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        alphabets = new char[c];
        selectedInd = new int[c];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            alphabets[i] = stk.nextToken().charAt(0);
        }
        Arrays.sort(alphabets);

        for (int i = 0; i <= c - l; i++) {
            dfs(i, 1);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int ind, int length) throws IOException {
        // 선택 문자의 인덱스를 저장하기
        selectedInd[length-1] = ind;

        // 길이가 요구했던 사항과 같을 때
        if (length == l) {
            // 모음이 1개 이상, 자음이 2개 이상일 때 암호 확정
            if (meetCondition()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < l; i++) {
                    sb.append(alphabets[selectedInd[i]]);
                }
                bw.write(sb + "\n");

                return;
            }
        }

        // 갈 수 있는 곳 선회 (현재 알파벳 다음부터 탐색)
        for (int i = ind + 1; i < c; i++) {
            dfs(i, length + 1);
        }

        // 선택 문자의 인덱스를 삭제하기(아무것도 하지 않기)
    }

    private static boolean meetCondition() {
        int mo = 0, ja = 0;
        for (int i = 0; i < l; i++) {
            char c = alphabets[selectedInd[i]];
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                mo++;
            else
                ja++;
        }

        if(mo >= 1 && ja >= 2)
            return true;
        else
            return false;
    }
}
