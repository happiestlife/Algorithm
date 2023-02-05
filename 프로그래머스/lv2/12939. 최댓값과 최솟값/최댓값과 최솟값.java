import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for( String strNum : nums){
            list.add(Integer.parseInt(strNum));
        }

        Collections.sort(list);
        String format = "%d %d";
        
        return String.format("%d %d", list.get(0), list.get(list.size()-1));
    }
}