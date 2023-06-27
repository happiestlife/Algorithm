import java.util.*;
class Solution {
    
    int step=0;
    
    public boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty())
                    return false;
                
                stack.pop();
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                sb.append(")");
            }
            else{
                sb.append("(");
            }
        }
        
        return sb.toString();
    }
    
    public String recur(String s){
        if(s.length() <= 1)
            return s;
        
        // 1. u와 v 분리
        String result = "";
        int openCnt = 0, closeCnt = 0;
        int i;
        for(i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                openCnt++;
            }
            else{
                closeCnt++;
            }
            
            if(openCnt == closeCnt){
                break;
            }
        }
        
        String u = s.substring(0, i + 1);
        String v = s.substring(i+1);
        
        step++;
        if(step > 10000)
            return result;
        
        // 2. u가 올바른 괄호 문자열인지 검사
        //    맞다면 result에 더하기 AND v에 대해서 1번부터 다시 수행
        if(isCorrect(u)){
            result += u;
            result += recur(v);
        }
        else{
            String tmp = "(";
            tmp += recur(v) + ")";
            u = u.substring(1, u.length() - 1);
            u = reverse(u);
            tmp += u;
            
            result = tmp;
        }
        
        return result;
    }
    
    public String solution(String p) {
        return recur(p);
    }
}