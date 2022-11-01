import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String str;
    static String bomb;

    public static void main(String[] args) throws IOException {
        // 기존 문자열을 받기 위한 스택
        Stack<Character> s = new Stack<>();
        // 비교를 하기 위한 스택
        Stack<Character> comp = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        bomb = br.readLine();

        for (int i = str.length()-1; i >= 0; i--) {
            /**
             *  1. s 스택에 넣기
             *  2. 폭탄 문자열의 첫번째 문자열과 만났을 때 비교 스택으로 하나씩 push 하면서 진행
             *  2-1. 만약 해당 문자열이 폭탄 문자열과 동일하면 비교문자열 clear
             *  2-2. 동일하지 않다면 비교문자열에 있던 모든 문자를 s에 되돌리기
             *  3. 끝까지 진행
             */
            char c = str.charAt(i);

            s.push(c);
            if(c == bomb.charAt(0)){
                for (int j = 0; j < bomb.length(); j++) {
                    if(s.isEmpty() || s.peek() != bomb.charAt(j)) {
                        while(!comp.isEmpty()){
                            s.push(comp.pop());
                        }
                        break;
                    }

                    comp.push(s.pop());

                    if(comp.size() == bomb.length()){
                        comp.clear();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(s.isEmpty()){
            sb.append("FRULA");
        }else{
            while(!s.isEmpty()){
                sb.append(s.pop());
            }
        }

        System.out.println(sb);

        br.close();
    }
}
