package P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class P5_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String curriculum = br.readLine();
        String plan = br.readLine();

        int cnt = 0;
        for (int i = 0; i < plan.length(); i++) {
            char c = plan.charAt(i);
            if (c == curriculum.charAt(cnt)) {
                cnt++;
                if(cnt == curriculum.length())
                    break;
            }
        }

        if(cnt == curriculum.length())
            System.out.println("YES");
        else
            System.out.println("NO");
        br.close();
    }
}
