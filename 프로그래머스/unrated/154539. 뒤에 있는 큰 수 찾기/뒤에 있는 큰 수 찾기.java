import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    
//     public int[] solution(int[] numbers) {
//         int[] rs = new int[numbers.length];
//         Stack<Integer> stack = new Stack<>();
//         for (int i = numbers.length - 1; i >= 0; i--) {
//             if(stack.isEmpty()){
//                 rs[i] = -1;
//             }
//             else if(numbers[i] < stack.peek()){
//                 rs[i] = stack.peek();
//             }
//             else{
//                 while(!stack.isEmpty() && stack.peek() <= numbers[i])
//                     stack.pop();

//                 if(stack.isEmpty())
//                     rs[i] = -1;
//                 else
//                     rs[i] = stack.peek();
//             }
//             stack.push(numbers[i]);
//         }

//         return rs;
//     }
    
    public int[] solution(int[] numbers) {
        int[] rs = new int[numbers.length];
        
        rs[numbers.length - 1] = -1;
        for (int i = rs.length - 2; i >= 0; i--) {
            if(numbers[i] < numbers[i+1]){
                rs[i] = numbers[i+1];
            }
            else{
                for (int j = i+1; j < rs.length; j++) {
                    if (rs[j] <= numbers[i]) {
                        if (rs[j] == -1) {
                            rs[i] = -1;
                            break;
                        }
                    }
                    if (rs[j] > numbers[i]) {
                        rs[i] = rs[j];
                        break;
                    }
                }
            }
        }

        return rs;
    }
}