import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // key : 선수 이름, value : 해당 이름을 가진 선수의 수
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < participant.length; i++){
            String p = participant[i];
            if(map.containsKey(p)){
                map.put(p, map.get(p) + 1);
            }else{
                map.put(p, 1);
            }
        }
        
        for(int i = 0; i < completion.length; i++){
            String c = completion[i];
            if(map.get(c) == 1){
                map.remove(c);
            }else{
                map.put(c, map.get(c) - 1);
            }
        }
        
        // 한명만 완주를 못했기 때문에 map에는 한명만 남아 있다.
        String rs = "";
        for(String s : map.keySet()){
            rs = s;
        }
        
        return rs;
    }
}