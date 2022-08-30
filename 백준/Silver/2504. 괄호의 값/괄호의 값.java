import java.io.*;
import java.util.Stack;

public class Main {
    /**
     * 문자열의 문자를 하나씩 지나가면서 list에 괄호의 깊이에 따른 값을 저장해놓고 사용하기 (index는 1부터)
     * 1) 리스트의 depth + 1의 값에 0이 들어있으면 2/3값을 depth 인덱스에 넣기
     * 2) 값이 0이 아니라면 해당 값과 2/3를 곱하고 depth+1 인덱스를 0으로 초기화, 곱한 값을 depth 인덱스에 넣기
     * ex) (([])) -> 0 2 2 3
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> s = new Stack<>();
        int cal[] = new int[31];

        int depth = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
//            System.out.print(c + " ");
            if (c == '(' || c == '[') {
                s.push(c);
                depth++;
            }
            else if (c == ')' || c == ']') {
                // 닫는 괄호보다 여는 괄호가 먼저 나온 경우 -> 실패
                if (s.isEmpty()) {
                    cal[1] = 0;
                    break;
                }
                // 괄호의 짝이 맞지 않는 경우 -> 실패
                else if ((c == ')' && s.peek() == '[') || (c == ']' && s.peek() == '(')) {
                    cal[1] = 0;
                    break;
                }

                // ch는 ( 나 /
                char ch = s.pop();
                int value = 0;
                if(ch == '(')
                    value = 2;
                else
                    value = 3;

                if (cal[depth + 1] != 0) {
                    value *= cal[depth + 1];
                    cal[depth + 1] = 0;
                }

                cal[depth--] += value;

//                for (int x : cal) {
//                    System.out.print(x + " ");
//                }
            }
        }

        // 여는 괄호가 남아있는 경우 -> 실패
        if(s.isEmpty() == false)
            cal[1] = 0;

        System.out.println(cal[1]);

        br.close();
    }
}