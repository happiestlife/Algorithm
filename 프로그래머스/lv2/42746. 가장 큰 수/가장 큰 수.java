import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    
//     static List<Integer> sortCase = new LinkedList<>();
    
//     static boolean[] isSelected;

//     static String biggestStrNum;
    
//     public String solution(int[] numbers) {
//         isSelected = new boolean[numbers.length];
//         for (int i = 0; i < numbers.length; i++) {
//             dfs(numbers, i);
//         }
        
//         return biggestStrNum;
//     }
    
//     public static void dfs(int[] numbers, int idx) {
//         isSelected[idx] = true;
//         sortCase.add(numbers[idx]);

//         if (sortCase.size() == numbers.length) {
//             StringBuilder curStrNum = new StringBuilder();
//             for (Integer num : sortCase) {
//                 curStrNum.append(num);
//             }

//             if(biggestStrNum == null){
//                 biggestStrNum = curStrNum.toString();
//             }
//             else{
//                 if (curStrNum.length() > biggestStrNum.length()) {
//                     biggestStrNum = curStrNum.toString();
//                 }
//                 else if (curStrNum.length() == biggestStrNum.length()
//                             && biggestStrNum.compareTo(curStrNum.toString()) < 0) {
//                     biggestStrNum = curStrNum.toString();
//                 }
//             }

//         }

//         for (int i = 0; i < numbers.length; i++) {
//             if(!isSelected[i]) {
//                 dfs(numbers, i);
//             }
//         }

//         isSelected[idx] = false;
//         sortCase.remove(sortCase.size() - 1);
//     }
    
//     public String solution(int[] numbers) {
//                 List<String> nums = new ArrayList<>(numbers.length);
//         boolean isOnlyZero = true;
//         for (int num : numbers) {
//             nums.add(String.valueOf(num));
//             if(num != 0)
//                 isOnlyZero = false;
//         }
//         if(isOnlyZero)
//             return "0";

//         Collections.sort(nums, (o1, o2) -> {
//             StringBuilder str1 = new StringBuilder(o1);
//             StringBuilder str2 = new StringBuilder(o2);

//             int idx = 0;
//             int max = Math.max(o1.length(), o2.length());
//             while(true) {
//                 char c1 = str1.charAt(idx);
//                 char c2 = str2.charAt(idx);
//                 if(c1 != c2)
//                     return c2 - c1;

//                 idx++;
//                 if(idx == max)
//                     break;

//                 if (idx == str1.length()) {
//                     str1.append(str1.charAt(str1.length() - 1));
//                 }
//                 if (idx == str2.length()) {
//                     str2.append(str2.charAt(str2.length() - 1));
//                 }

//             }

//             return o1.length() - o2.length();
//         });

//         StringBuilder sb = new StringBuilder();
//         for (String num : nums) {
//             sb.append(num);
//         }

//         return sb.toString();
//     }
    
    public String solution(int[] numbers) {
        List<String> nums = new ArrayList<>(numbers.length);
        boolean isOnlyZero = true;
        for (int num : numbers) {
            nums.add(String.valueOf(num));
            if(num != 0)
                isOnlyZero = false;
        }
        if(isOnlyZero)
            return "0";

        Collections.sort(nums, (o1, o2) -> {
            StringBuilder str1 = new StringBuilder(o1);
            StringBuilder str2 = new StringBuilder(o2);

            str1.append(o2);
            str2.append(o1);

            return str2.compareTo(str1);
        });

        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }
}