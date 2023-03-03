import java.util.*;

class Solution {
    public int solution(int[] elements) {
//         int size = elements.length;

//         Set<Integer> rs = new HashSet<>();
//         // i : 요소의 개수
//         for (int i = 1; i <= size; i++) {
//             // 항상 모든 요소를 더해서 총합 구하기
//             for (int j = 0; j < size; j++) {
//                 int sum = 0;
//                 for (int k = j; k < j + i; k++) {
//                     sum += elements[k % size];
//                 }
//                 rs.add(sum);
//             }
//         }
        
//         return rs.size();
        
                int size = elements.length;

        Set<Integer> rs = new HashSet<>();
        // i : 요소의 개수
        for (int i = 1; i <= size; i++) {
            // i 개의 요소(0 ~ i-1)에 대한 합 구하기
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += elements[j];
            }

            // 현재 요소를 합에서 빼고 다음 요소를 더하기
            for (int j = 0; j < size - 1; j++) {
                rs.add(sum);
                sum -= elements[j];
                sum += elements[(j + i) % size];
            }
            // 마지막 요소 더하기
            rs.add(sum);
        }
        
        return rs.size();
    }
}