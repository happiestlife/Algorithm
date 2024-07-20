import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class Solution {
    
    public long solution(String[][] clothes) {
        Map<String, List<String>> clothByType = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1];
            String clothName = cloth[0];

            if(clothByType.containsKey(type)) {
                clothByType.get(type).add(clothName);
            }
            else {
                List<String> newClothes = new ArrayList<>();
                newClothes.add(clothName);
                clothByType.put(type, newClothes);
            }
        }
        
        int sum = 1;
        for(String clothType : clothByType.keySet()) {
            int clothTypeCnt = clothByType.get(clothType).size();
            
            sum = sum * (clothTypeCnt + 1);
        }

        return sum - 1;
    }
}