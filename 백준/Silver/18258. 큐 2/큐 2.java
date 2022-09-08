import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> q = new LinkedList<>();

        String cmd;
        StringTokenizer stk;
        while (n-- > 0) {
            stk = new StringTokenizer(br.readLine());

            cmd = stk.nextToken();
            // push
            char c = cmd.charAt(0);
            if(c == 'p' && cmd.length() == 4){
                q.add(Integer.parseInt(stk.nextToken()));
            }
            // pop
            else if (c == 'p') {
                if(q.isEmpty())
                    bw.write("-1\n");
                else {
                    bw.write(q.get(0) + "\n");
                    q.remove(0);
                }
            }
            // size
            else if (c == 's') {
                bw.write(q.size() + "\n");
            }
            // empty
            else if (c == 'e') {
                if(q.isEmpty())
                    bw.write("1\n");
                else
                    bw.write("0\n");
            }
            // front
            else if (c == 'f') {
                if(q.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(q.get(0) + "\n");
            }
            // back
            else {
                if(q.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(q.get(q.size()-1) + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

