class Solution {
//     public long[] solution(long[] numbers) {
//         int idx = 0;
//         long[] rs = new long[numbers.length];
//         for (int i = 0; i < numbers.length; i++) {
//             long number = numbers[i];

//             long tmpNum = number + 1;
//             while(true){
//                 String binaryStr = Long.toBinaryString(tmpNum ^ number);
//                 int oneCnt = 0, oneIdx = -1;
//                 while(true){
//                     oneIdx = binaryStr.indexOf('1', oneIdx+1);
//                     if(oneIdx == -1){
//                         break;
//                     }
//                     if(oneCnt > 2)
//                         break;
//                     oneCnt++;
//                 }

//                 if(oneCnt <= 2){
//                     break;
//                 }

//                 tmpNum++;
//             }

//             rs[idx++] = tmpNum;
//         }
        
//         return rs;
//     }
    
    public long[] solution(long[] numbers) {
        int idx = 0;
        long[] rs = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            // num이 2^n-1 인지 검사
            StringBuilder standardBinaryStr = new StringBuilder(Long.toBinaryString(num));
            if(standardBinaryStr.indexOf("0") == -1){
                standardBinaryStr.append('1');
                standardBinaryStr.setCharAt(1, '0');
            }else{
                // 이진수중 가장 높은 위치를 제외한 곳에서 1이 한개라도 있는 경우
                for (int j = standardBinaryStr.length() - 1; j >= 0; j--) {
                    char c = standardBinaryStr.charAt(j);
                    if(c == '0'){
                        standardBinaryStr.setCharAt(j, '1');
                        break;
                    }
                    else if(c == '1' && standardBinaryStr.charAt(j - 1) == '0' && j > 0){
                        standardBinaryStr.setCharAt(j, '0');
                        standardBinaryStr.setCharAt(j - 1, '1');
                        break;
                    }
                }
            }

            long result = Long.parseLong(standardBinaryStr.toString(), 2);
            rs[idx++] = result;
        }
        return rs;
    }
}