import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> main = new Stack<>();
        Stack<Character> rest = new Stack<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            main.push(s.charAt(i));
        }

        n = Integer.parseInt(br.readLine());

        char cmd, c;
        StringTokenizer stk;
        while (n-- > 0) {
            stk = new StringTokenizer(br.readLine());

            cmd = stk.nextToken().charAt(0);
            switch (cmd) {
                case 'L':
                    if(!main.isEmpty())
                        rest.push(main.pop());
                    break;
                case 'D':
                    if(!rest.isEmpty())
                        main.push(rest.pop());
                    break;
                case 'B':
                    if(!main.isEmpty())
                        main.pop();
                    break;
                case 'P':
                    main.add(stk.nextToken().charAt(0));
                    break;
            }
        }

        while (!main.isEmpty()) {
            rest.push(main.pop());
        }

        while (!rest.isEmpty()) {
            bw.write(rest.pop());
        }

        bw.flush();
        br.close();
        bw.close();
    }
}