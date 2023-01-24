import java.util.Stack;

class Solution {
    
    static int num = 0;
    static char bonus;
    static char option = 0;
    static Stack<Integer> stack = new Stack<>();
    
    public int solution(String drs) {
        
        for(int i = 0; i < drs.length(); i++){
            // 1. 문자열 분해
            i = analyze(drs, i);
            if(i == -1){
                break;
            }
            
            // 2. s/d/t 연살 실시
            calcBonus();

            // 3. */#이 있다면 연산 실시
            calcOption();

            // 스택에 추가하기
            stack.push(num);
            
            // 숫자, 옵션 초기화 (보너스는 항상 새로 교체되기 때문에 실시 X)
            num = 0;
            option = 0;
        }
        
        int rs = 0;
        while(!stack.isEmpty()){
            rs += stack.pop();
        }
        
        return rs;
    }
    
    // 문자열 분해
    public static int analyze(String s, int i){
        // 1-1. 숫자 구하기
        while('0' <= s.charAt(i) && s.charAt(i) <= '9'){
            num = num * 10 + (s.charAt(i++) - '0');
        }

        // 1-2. 보너스 구하기
        bonus = s.charAt(i);

        // 1-3. 옵션이 있다면 옵션 구하기
        if(i+1 >= s.length()){
            calcBonus();
            stack.push(num);
            
            return -1;
        }
        char opt = s.charAt(i+1);
        if(opt == '*' || opt == '#'){
            option = opt;
            i++;
        }
        
        return i;
    }
    
    // s/d/t 연살 실시
    public static void calcBonus(){
        switch(bonus){
            case 'D':
                num = (int)Math.pow(num, 2);
                break;
            case 'T':
                num = (int)Math.pow(num, 3);
                break;
        }
    }
    
    // */#이 있다면 연산 실시
    public static void calcOption(){
        switch(option){
            case '*':
                if(!stack.isEmpty()){
                    stack.push(stack.pop() * 2);
                }
                num *= 2;
                break;
            case '#':
                num *= -1;
                break;
        }
    }
}