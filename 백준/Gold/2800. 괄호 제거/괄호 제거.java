import java.io.*;
import java.util.*;

public class Main {

    static String str;
    static boolean isDeleted[];
    static List<int[]> couple;
    static List<int[]> pos;

    static List<String> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        isDeleted = new boolean[str.length()];
        couple = new ArrayList<>();
        results = new ArrayList<>();
        pos = new ArrayList<>();

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                s.push(i);
            } else if(c == ')') {
                couple.add(new int[]{i, s.pop()});
            }
        }

        // 지울 괄호쌍 개수 정하기
        for (int i = 1; i <= couple.size(); i++) {
            // 지우기 시작 부분
            for (int j = 0; j < couple.size(); j++) {
                findInd(i, 1, j);
            }
        }

        // 중복을 제거해줘야 한다.
        results = new ArrayList<>(new HashSet<String>(results));
        Collections.sort(results);

        for (String st : results) {
            bw.write(st + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }


    static void findInd(int count, int now, int ind) {
        pos.add(new int[]{couple.get(ind)[0], couple.get(ind)[1]});

        if (now == count) {
            makeString();
            pos.remove(pos.size() - 1);
            return;
        }

        for (int i = ind + 1; i < couple.size(); i++) {
            findInd(count, now + 1, i);
        }

        pos.remove(pos.size() - 1);
    }

    static void makeString() {
        for (int[] p : pos) {
            isDeleted[p[0]] = isDeleted[p[1]] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(isDeleted[i] == false)
                sb.append(str.charAt(i));
        }

        results.add(sb.toString());

        Arrays.fill(isDeleted, false);
    }
}
