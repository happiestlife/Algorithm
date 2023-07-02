import java.util.*;

class Solution {
    
    class Node{
        long num;
        char oper;
        
        public Node(long num){
            this.num = num;
            this.oper = 'n';
        }
        
        public Node(char oper){
            this.oper = oper;
        }
    }
    
    long max;
    final char[] oper = {'+', '-', '*'};
    boolean[] isVisited = new boolean[oper.length];
    Map<Character, Integer> priorityByOper = new HashMap<>();
    
    public void findCase(String expression, int curIdx){
        isVisited[curIdx] = true;
        priorityByOper.put(oper[curIdx], priorityByOper.size() + 1);
        if(priorityByOper.size() == oper.length){
            calculate(expression);
        }
        
        for(int i = 0; i < oper.length; i++){
            if(!isVisited[i]){
                findCase(expression, i);
            }
        }
        
        isVisited[curIdx] = false;
        priorityByOper.remove(oper[curIdx]);
    }
    
    public void calculate(String expression){
        List<Node> postExpr = new ArrayList<>();
        Stack<Character> tmpOper = new Stack<>();
        
        // 1. 후위 연산식 생성
        int tmpNum = 0;
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '-' || c == '+' || c == '*'){
                postExpr.add(new Node(tmpNum));
                tmpNum = 0;
                
                while(!tmpOper.isEmpty() && priorityByOper.get(tmpOper.peek()) >= priorityByOper.get(c)){
                    postExpr.add(new Node(tmpOper.pop()));
                }
                tmpOper.push(c);
            }
            else{
                tmpNum = tmpNum * 10 + Character.getNumericValue(c);
            }
        }
        postExpr.add(new Node(tmpNum));
        while(!tmpOper.isEmpty()){
            postExpr.add(new Node(tmpOper.pop()));
        }
        
        // 2. 후위 연산식 계산
        Stack<Long> s = new Stack<>();
        for(int i = 0; i < postExpr.size(); i++){
            Node v = postExpr.get(i);
            if(v.oper != 'n'){
                long op2 = s.pop();
                long op1 = s.pop();
                if(v.oper == '+'){
                    s.push(op1 + op2);
                }
                else if(v.oper == '-'){
                    s.push(op1 - op2);
                }
                else{
                    s.push(op1 * op2);
                }
            }
            else{
                s.push(v.num);
            }
        }
        max = Math.max(max, Math.abs(s.peek()));
    }
    
    public long solution(String expression) {
        for(int i = 0; i < oper.length; i++){
            findCase(expression, i);
        }
        
        return max;
    }
}