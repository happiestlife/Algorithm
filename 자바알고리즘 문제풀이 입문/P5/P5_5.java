package P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P5_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rs = 0;
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push('(');
            }
            else{
                stack.pop();
                // 레이저인 경우
                if(str.charAt(i-1) == '('){
                    rs += stack.size();
                }
                // 막대기가 끝나는 경우
                else{
                    rs++;
                }
            }
        }

        System.out.println(rs);

        br.close();
    }
}
