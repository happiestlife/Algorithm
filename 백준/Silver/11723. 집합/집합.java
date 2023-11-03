import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String cmdStr = br.readLine();
            String[] comp = cmdStr.split(" ");

            String cmd = comp[0];

            int value = 0;
            if(comp.length == 2) {
                value = Integer.parseInt(comp[1]);
            }

            if (cmd.equals("add")) {
                set.add(value);
            } else if (cmd.equals("remove")) {
                set.remove(value);
            } else if (cmd.equals("check")) {
                if (set.contains(value)) {
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            } else if (cmd.equals("toggle")) {
                if (set.contains(value)) {
                    set.remove(value);
                }else{
                    set.add(value);
                }
            } else if (cmd.equals("all")) {
                set.clear();
                for (int i = 1; i <= 20; i++) {
                    set.add(i);
                }
            } else {
                set.clear();
            }
        }

        System.out.println(sb);

        br.close();
    }
}
