import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<>();
        String[] comp = br.readLine().split(" ");
        int a = Integer.parseInt(comp[0]);
        int b = Integer.parseInt(comp[1]);
        for (int i = 0; i < a; i++) {
            comp = br.readLine().split(" ");
            String domain = comp[0];
            String password = comp[1];

            map.put(domain, password);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b; i++) {
            String findDomain = br.readLine();
            sb.append(map.get(findDomain) + "\n");
        }

        System.out.println(sb);

        br.close();
    }
}
