import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();

        List<Integer> ps = new ArrayList<>();
        int idx = 0;
        while (idx < str.length()) {
            char c = str.charAt(idx);
            if (c == 'I') {
                idx++;
                boolean isITurn = false;

                int len = 0;
                while (idx < str.length()) {
                    c = str.charAt(idx);
                    if (isITurn && c == 'I') {
                        isITurn = false;
                        len++;
                    }
                    else if (!isITurn && c == 'O') {
                        isITurn = true;
                    }
                    else {
                        idx--;
                        break;
                    }

                    idx++;
                }

                if(len >= n){
                    ps.add(len);
                }
            }

            idx++;
        }

        int sum = 0;
        for (int len : ps) {
            sum += len - n + 1;
        }
        System.out.println(sum);

        br.close();
    }

}
