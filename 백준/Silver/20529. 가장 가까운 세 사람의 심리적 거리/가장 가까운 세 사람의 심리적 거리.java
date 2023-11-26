import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());
            Map<String, Integer> cntByMbti = new HashMap<>();
            while(stk.hasMoreTokens()){
                String mbti = stk.nextToken();
                if (!cntByMbti.containsKey(mbti)) {
                    cntByMbti.put(mbti, 1);
                }
                else{
                    cntByMbti.put(mbti, cntByMbti.get(mbti) + 1);
                }
            }

            List<String> mbtis = new ArrayList<>();
            for (String mbti : cntByMbti.keySet()) {
                int cnt = Math.min(cntByMbti.get(mbti), 3);
                for (int i = 0; i < cnt; i++) {
                    mbtis.add(mbti);
                }
            }

            int minDist = Integer.MAX_VALUE;
            for (int idx1 = 0; idx1 < mbtis.size(); idx1++) {
                for (int idx2 = 0; idx2 < mbtis.size(); idx2++) {
                    if(idx2 == idx1) continue;

                    for (int idx3 = 0; idx3 < mbtis.size(); idx3++) {
                        if(idx3 == idx1 || idx3 == idx2) continue;

                        int dist1 = getDiffCnt(mbtis.get(idx1), mbtis.get(idx2));
                        int dist2 = getDiffCnt(mbtis.get(idx2), mbtis.get(idx3));
                        int dist3 = getDiffCnt(mbtis.get(idx3), mbtis.get(idx1));

                        int distSum = dist1 + dist2 + dist3;

                        minDist = Math.min(minDist, distSum);
                    }
                }
            }

            sb.append(minDist + "\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static int getDiffCnt(String d1, String d2) {
        int diffCnt = 0;
        for (int i = 0; i < d1.length(); i++) {
            char c1 = d1.charAt(i);
            char c2 = d2.charAt(i);

            if(c1 != c2){
                diffCnt++;
            }
        }

        return diffCnt;
    }
}
