import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        q = new LinkedList<>();

        StringTokenizer stk;
        while (n-- > 0) {
            stk = new StringTokenizer(br.readLine());
            String cmd = stk.nextToken();
            if (cmd.equals("push")) {
                q.add(Integer.parseInt(stk.nextToken()));
            }
            else if (cmd.equals("pop")) {
                if(q.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(q.remove(0) + "\n");
            }
            else if (cmd.equals("size")) {
                bw.write(q.size() + "\n");
            }
            else if (cmd.equals("empty")) {
                bw.write((q.isEmpty() ? 1 : 0) + "\n");
            }
            else if (cmd.equals("front")) {
                if(q.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(q.get(0)+"\n");
            } else if (cmd.equals("back")) {
                if(q.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(q.get(q.size() - 1)+"\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
