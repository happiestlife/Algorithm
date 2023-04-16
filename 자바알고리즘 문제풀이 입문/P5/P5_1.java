package P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P5_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        String result = "YES";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push('(');
            }else{
                if (stack.isEmpty()) {
                    result = "NO";
                    break;
                }

                stack.pop();
            }
        }

        if(!stack.isEmpty()){
            result = "NO";
        }

        System.out.println(result);

        br.close();
    }
}
