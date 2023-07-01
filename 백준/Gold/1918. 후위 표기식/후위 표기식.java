import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expr = br.readLine();
        List<Character> result = new LinkedList<>();
        Stack<Character> tmpOper = new Stack<>();

        Map<Character, Integer> operPriority = new HashMap<>();
        operPriority.put('(', 0);
        operPriority.put('+', 1);
        operPriority.put('-', 1);
        operPriority.put('*', 2);
        operPriority.put('/', 2);

        for(int i = 0; i < expr.length(); i++){
            char c = expr.charAt(i);
            if(c == '('){
                tmpOper.push(c);
            }
            else if(c == ')'){
                while(true){
                    char opr = tmpOper.pop();
                    if(opr == '(')
                        break;

                    result.add(opr);
                }
            }
            else if(c == '+' || c == '-' || c == '*' || c == '/'){
                while(!tmpOper.isEmpty() && operPriority.get(c) <= operPriority.get(tmpOper.peek())){
                    result.add(tmpOper.pop());
                }
                tmpOper.push(c);
            }
            else{
                result.add(c);
            }
        }
        while(!tmpOper.isEmpty())
            result.add(tmpOper.pop());

        StringBuilder sb = new StringBuilder();
        for(Character c : result){
            sb.append(c);
        }

        System.out.println(sb.toString());

        br.close();
    }
}