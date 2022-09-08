import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int level = 1;
        boolean isFailed = false;
        Stack<Integer> s = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if ((s.isEmpty() && level > nums[i]) ||
                    (!s.isEmpty() && s.peek() < nums[i] && level > nums[i])) {
                isFailed = true;
                break;
            }

            if (s.isEmpty() || s.peek() < nums[i]) {
                do {
                    s.push(level++);
                    sb.append("+\n");
                } while (s.peek() < nums[i]);
            }
            else if(s.peek() > nums[i]) {
                while(s.peek() > nums[i]){
                    s.pop();
                    sb.append("-\n");
                }
            }

            s.pop();
            sb.append("-\n");
        }

        if(isFailed)
            System.out.println("NO\n");
        else
            System.out.println(sb);

        br.close();
    }
}
