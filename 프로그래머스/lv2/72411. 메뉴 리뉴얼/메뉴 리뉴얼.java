import java.util.*;

class Solution {
    
    boolean[] isVisited;
    StringBuilder sb;
    Map<String, Integer>[] setMenusMap;
    
    public void getSetMenu(String s, int idx, int maxMenuCnt, int mapIdx){
        sb.append(s.charAt(idx));
        isVisited[idx] = true;
        if(sb.length() == maxMenuCnt){
            String set = sb.toString();
            if(setMenusMap[mapIdx].containsKey(set)){
                setMenusMap[mapIdx].put(sb.toString(), setMenusMap[mapIdx].get(set) + 1);
            }
            else{
                setMenusMap[mapIdx].put(sb.toString(), 1);
            }
            sb.deleteCharAt(sb.length() - 1);
            isVisited[idx] = false;
            return;
        }
        
        for(int i = idx + 1; i < s.length(); i++){
            if(!isVisited[i]){
                getSetMenu(s, i, maxMenuCnt, mapIdx);
            }
        }
        
        
        sb.deleteCharAt(sb.length() - 1);
        isVisited[idx] = false;
    }
    
    public String[] solution(String[] orders, int[] course) {

        setMenusMap = new HashMap[course.length];
        for(int i = 0; i < course.length; i++){
            setMenusMap[i] = new HashMap<>();
        }
        for(int i = 0; i < orders.length; i++){
            String order = orders[i];
            
            // 1. 주문 오름차순 정렬
            char[] orderComp = order.toCharArray();
            Arrays.sort(orderComp);
            order = new String(orderComp);
                    
            // 2. course에 대한 세트 종류 넣기
            isVisited = new boolean[order.length()];
            sb = new StringBuilder();
            
            for(int j = 0; j < course.length; j++){
                int menuCnt = course[j];
                if(menuCnt > order.length())
                    break;
                
                for(int k = 0; k < order.length(); k++){
                    getSetMenu(order, k, menuCnt, j);
                }
            }
        }
        
        List<String> result = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        for(Map<String, Integer> m : setMenusMap){
            int maxCnt = 0;
            for(Map.Entry<String, Integer> e : m.entrySet()){
                // System.out.println(e.getKey() + ", cnt : " + e.getValue());
                String set = e.getKey();
                int setCnt = e.getValue();
                if(setCnt > maxCnt){
                    tmp.clear();
                    maxCnt = setCnt;
                    tmp.add(set);
                }
                else if(setCnt == maxCnt){
                    tmp.add(set);
                }
            }
            if(maxCnt <= 1){
                continue;
            }
            
            for(String set : tmp){
                result.add(set);
            }
        }
        
        Collections.sort(result);
        
        
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}