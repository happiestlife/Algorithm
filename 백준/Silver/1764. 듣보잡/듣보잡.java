import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> aSet = new HashSet<>();
        List<String> rs = new ArrayList<>();

        String[] comp = br.readLine().split(" ");
        int aCnt = Integer.parseInt(comp[0]);
        int bCnt = Integer.parseInt(comp[1]);
        for (int i = 0; i < aCnt; i++) {
            aSet.add(br.readLine());
        }
        for (int i = 0; i < bCnt; i++) {
            String bStr = br.readLine();
            if (aSet.contains(bStr)) {
                rs.add(bStr);
            }
        }

        Collections.sort(rs);
        StringBuilder sb = new StringBuilder();
        sb.append(rs.size() + "\n");
        for (int i = 0; i < rs.size(); i++) {
            sb.append(rs.get(i) + "\n");
        }

        System.out.println(sb);

        br.close();
    }
}
