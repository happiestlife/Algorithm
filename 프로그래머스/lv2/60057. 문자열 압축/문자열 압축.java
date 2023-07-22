import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        List<String> strs = new ArrayList<>();
        for(int i = 1; i <= len; i++){
            int idx = 0, cnt = 1;
            String before = "";
            StringBuilder result = new StringBuilder();
            // System.out.println("count : " + i);
            while(idx < len){
                StringBuilder cur = new StringBuilder();
                for(int curIdx = 0; idx < len && curIdx < i; curIdx++, idx++){
                    cur.append(s.charAt(idx));
                }
                
                // System.out.println(cur.toString() + ", " + idx);
                
                if(cur.toString().equals(before)){
                    cnt++;
                }
                else{
                    String comp = before;
                    if(cnt >= 2){
                        comp = cnt + before;
                    }
                    result.append(comp);
                    
                    before = cur.toString();
                    cnt = 1;
                }
            }
            String comp = before;
            if(cnt >= 2){
                comp = cnt + before;
            }
            result.append(comp);
            
            // System.out.println("result >> " + result.toString());
            strs.add(result.toString());
        }
        
        // for(String ss : strs){
        //     System.out.println(ss);
        // }
        
        Collections.sort(strs, (s1, s2) ->{
            return s1.length() - s2.length();
        });
        
        return strs.get(0).length();
    }
}