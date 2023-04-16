package P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P5_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        List<int[]> remainderPoint = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else if (c == ')') {
                stack.pop();
            }
            else if(stack.isEmpty()){
                sb.append(c);
            }

        }

        System.out.println(sb);

        br.close();
    }
}
