import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        // 각 알파벳에 대한 숫자
        // 스택의 가장 윗부분에 문자열의 현재 문자와 동일한 문자의 가장 가까운 인덱스 반환
        Stack<Integer>[] alpha = new Stack[26];
                
        List<Integer> ind = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            // 앞에 자신과 같은 문자가 없을 경우
            if(alpha[c] == null){
                ind.add(-1);
                
                alpha[c] = new Stack<>();
            }
            // 앞에 자신과 같은 문자가 있을 경우
            else{
                // 현재 인덱스와 가장 최신의 문자에 대한 인덱스 비교
                ind.add(i - alpha[c].peek());
            }
            alpha[c].push(i);
        }
        
        int[] rs = new int[ind.size()];
        for(int i = 0; i < rs.length; i++){
            rs[i] = ind.get(i);
        }
        
        return rs;
    }
}