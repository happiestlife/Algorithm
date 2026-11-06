import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtest(result, new char[2 * n], 0, 0, 0, n);

        return result;
    }

    private void backtest(List<String> result, char[] curComp, int index, int openCharCnt, int closeCharCnt, int n) {
        if(index == curComp.length) {
            result.add(new String(curComp));
            return;
        }

        if(openCharCnt < n) {
            curComp[index] = '(';
            backtest(result, curComp, index+1, openCharCnt+1, closeCharCnt, n);
        }

        if(closeCharCnt < openCharCnt) {
            curComp[index] = ')';
            backtest(result, curComp, index+1, openCharCnt, closeCharCnt+1, n);
        }
    }

    // public List<String> generateParenthesis(int n) {
    //     Set<String>[] pairComps = new Set[n+1];
    //     pairComps[1] = new HashSet<>(){{
    //         add("()");
    //     }};

    //     for(int i = 2; i <= n; i++) {
    //         Set<String> curPairComps = new HashSet<>();
    //         Set<String> prevPairComps = pairComps[i-1];

    //         int curPairCaseLength= 6 * i - 4;
    //         // 이전 쌍에 대해서 ()를 추가하기
    //         for(String prevPairComp : prevPairComps) {
    //             // 여는, 닫는 괄호의 인덱스 구하기
    //             for(int openIdx = 0; openIdx < curPairCaseLength-1; openIdx++) {
    //                 if(openIdx % 3 == 2) continue;
    //                 for(int closeIdx = openIdx + 1; closeIdx < curPairCaseLength; closeIdx++) {
    //                     if(closeIdx % 3 == 2) continue;

    //                     // 현재 컴포넌트 구하기 
    //                     StringBuilder curComp = new StringBuilder();
    //                     // System.out.println(curPairCaseLength + " > " + openIdx + ", " + closeIdx);
    //                     for(int x = 0; x < curPairCaseLength; x++) {
    //                         // 여는, 닫는 괄호의 인덱스가 가리키지 않는 위치는 패스
    //                         if(x != openIdx && x != closeIdx && x % 3 != 2) continue;
    //                         else if(x % 3 == 2) {
    //                             curComp.append(prevPairComp.charAt(x/3));
    //                         }
    //                         // %3==2인 시점에는 이전 문자열의 /3 위치의 문자 넣기
    //                         else if (x == openIdx){
    //                             curComp.append("(");
    //                         } else if(x == closeIdx) {
    //                             curComp.append(")");
    //                         }
    //                     }

    //                     // System.out.println(curComp);
    //                     curPairComps.add(curComp.toString());
    //                 }
    //             }
    //         }

    //         pairComps[i] = curPairComps;
    //     }
         
    //     List<String> result = new ArrayList<>(pairComps[n]);

    //     return result;
    // }


}