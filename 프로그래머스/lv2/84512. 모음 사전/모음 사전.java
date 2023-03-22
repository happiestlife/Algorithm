class Solution {
    
    static long num;
    static final char[] DICTIONARY = {'A', 'E', 'I', 'O', 'U'};
    
//     public long solution(String word) {
//         StringBuilder str = new StringBuilder();
//         for (int i = 0; i < DICTIONARY.length; i++) {
//             if (dfs(word, str, i))
//                 break;
//         }
        
//         return num;
//     }
    
//     public static boolean dfs(String word, StringBuilder str, int idx) {
//         num++;
//         str.append(DICTIONARY[idx]);

//         boolean isSuccess = false;
//         if(str.length() == word.length() && str.toString().equals(word)){
//             return true;
//         }
//         else if(str.length() < DICTIONARY.length) {
//             for (int i = 0; i < DICTIONARY.length; i++) {
//                 if (isSuccess = dfs(word, str, i))
//                     break;
//             }
//         }
    
//         str.deleteCharAt(str.length() - 1);

//         return isSuccess;
//     }
    
    public long solution(String word) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < DICTIONARY.length; i++) {
            if(word.charAt(str.length()) == DICTIONARY[i]) {
                if (dfs(word, str, i))
                    break;
            }else{
                add(str);
            }
        }
        
        return num;
    }
    
    public static boolean dfs(String word, StringBuilder str, int idx) {
        num++;
        str.append(DICTIONARY[idx]);

        boolean isSuccess = false;
        if(str.length() == word.length() && str.toString().equals(word)){
            return true;
        }
        else if(str.length() < DICTIONARY.length) {
            for (int i = 0; i < DICTIONARY.length; i++) {
                if(word.charAt(str.length()) == DICTIONARY[i]) {
                    if (isSuccess = dfs(word, str, i))
                        break;
                }else{
                    add(str);
                }
            }
        }

        str.deleteCharAt(str.length() - 1);

        return isSuccess;
    }
    
    // 문자열과 다른 문자에 대해서는 경우의 수를 계산해서 num에 더해준다. 
    // Ex) 찾아야 하는 문자열 : I
    //     현재 문자열 : 빈문자열
    //  -> Axxxx : 1 + 5 + 5*5 + 5*5*5 + 5*5*5*5
    //     Exxxx : 1 + 5 + 5*5 + 5*5*5 + 5*5*5*5
    //     I     : 1
    public static void add(StringBuilder str) {
        for (int i = 1; i <= DICTIONARY.length - str.length() - 1; i++) {
            num += (long)Math.pow(DICTIONARY.length, i);
        }
        // Axxxx에 대해서 계산한다고 했을 때, A에 대한 횟수 1을 더해준다.
        num++;
    }

}