import java.util.*;

class Solution {
    
    private static final char DEFAULT = 'A';
    
//     public int solution(String name) {
//         int cnt = 0, needToConvertCnt = 0;
//         for(int i = 0; i < name.length(); i++){
//             char c = name.charAt(i);
//             if(c != DEFAULT){
//                 cnt += getMinCntToMakeChar(name.charAt(i));
//                 needToConvertCnt++;
//             }
//         }
        
//         StringBuilder decal = new StringBuilder();
//         for(int i = 1; i < name.length(); i++){
//             decal.append(name.charAt(i));
//         }
//         decal.append(name);
//         System.out.println(decal);
    
//         int moveCnt = 0;
//         int findConvertCnt = 0, left = name.length() - 1, right = name.length() - 1;
//         if(decal.length() == 1){
//             left = right = 0;
//         }
//         while(moveCnt < name.length()){
//             System.out.println(decal.charAt(left) + "|" + left + ", " + decal.charAt(right)  + "|" + right + ">>" + findConvertCnt + ", " + needToConvertCnt);
//             if(decal.charAt(left) != DEFAULT){
//                 findConvertCnt++;
//                 if(findConvertCnt == needToConvertCnt){
//                     break;
//                 }
//             }
//             if(left != right && decal.charAt(right) != DEFAULT){
//                 findConvertCnt++;
//                 if(findConvertCnt == needToConvertCnt){
//                     break;
//                 }
//             }
//             left--;
//             if(left < 0){
//                 left = decal.length() - 1;
//             }
//             right++;
//             if(right >= decal.length()){
//                 right = 0;
//             }
//             moveCnt++;
//         }
        
//         System.out.println(left + ", " + right);
//         if(left == right && right == 0){
//             right = name.length() - 1;
//         }
//         if(left > right){
//             int tmp = left;
//             left = right;
//             right = tmp;
//         }
        
        
//         System.out.println(left + ", " + right);
//         if(left < right){
//             cnt += left * 2;
//         }
//         else{
//             cnt += right * 2;
//         }
        
//         return cnt;
//     }
    
    public int getMinCntToMakeChar(char c){
        int nextCnt = c - DEFAULT;
        int prevCnt = 1 + 'Z' - c;
        
        return Math.min(nextCnt, prevCnt);
    }
    
    private int dept = 0;
    private String name;
    private int needToConvertCnt;
    
    private boolean[] isVisited;
    
    public int dfs(int curMoveCnt, int idx, int visitCnt){
        dept++;
        if(visitCnt == needToConvertCnt){
            dept--;
            return 0;
        }
        isVisited[idx] = true;
        
        int[] leftRs = findLeft(idx);
        for(int i = 0; i < dept; i++){
            System.out.print(" ");
        }
        System.out.println("left ( " + dept + " )>> " + leftRs[0]);
        int leftCaseCnt = dfs(curMoveCnt + leftRs[1], leftRs[0], visitCnt + 1) + leftRs[1];
        for(int i = 0; i < dept; i++){
            System.out.print(" ");
        }
        System.out.println("left result( " + dept + " )>> " + leftCaseCnt);
        
        int[] rightRs = findRight(idx);
        for(int i = 0; i < dept; i++){
            System.out.print(" ");
        }
        System.out.println("right ( " + dept + " )>> " + rightRs[0] + ", " + rightRs[1]);
        int rightCaseCnt = dfs(curMoveCnt + rightRs[1], rightRs[0], visitCnt + 1) + rightRs[1];
        for(int i = 0; i < dept; i++){
            System.out.print(" ");
        }
        System.out.println("right result( " + dept + " )>> " + rightCaseCnt);

        isVisited[idx] = false;
        dept--;
        return Math.min(leftCaseCnt, rightCaseCnt);
    }
    
    public int[] findLeft(int idx){
        int moveCnt = 0;
        while(true){
            if(!isVisited[idx] && name.charAt(idx) != DEFAULT){
                break;
            }
            
            idx--;
            if(idx < 0){
                idx = name.length() - 1;
            }
            moveCnt++;
        }
        for(int i = 0; i < dept; i++){
            System.out.print(" ");
        }
        System.out.println("left >> " + idx + ", " + moveCnt);
        return new int[]{idx, moveCnt};
    }
    
    public int[] findRight(int idx){
        int moveCnt = 0;
        while(true){
            if(!isVisited[idx] && name.charAt(idx) != DEFAULT){
                break;
            }
            
            idx++;
            if(idx >= name.length()){
                idx = 0;
            }
            moveCnt++;
        }
        for(int i = 0; i < dept; i++){
            System.out.print(" ");
        }
        System.out.println("right >> " + idx + ", " + moveCnt);
        return new int[]{idx, moveCnt};
    }
    
    public int solution(String name) {
        this.isVisited = new boolean[name.length()];
        this.name = name;
        int cost = 0;
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            if(c != DEFAULT){
                this.needToConvertCnt++;
                cost += getMinCntToMakeChar(c);
            }
        }
        
        if(needToConvertCnt > 0 && name.length() > 1){
            int[] leftRs = findLeft(0);
            int[] rightRs = findRight(0);
            // System.out.println("left >> " + leftRs[0] + ", " + leftRs[1]);
            // System.out.println("right >> " + rightRs[0] + ", " + rightRs[1]);
            if(leftRs[0] == rightRs[0]){
                int mCnt = Math.min(leftRs[1], rightRs[1]);
                cost += dfs(mCnt, leftRs[0], 1) + mCnt;
            }
            else{
                int leftCnt = dfs(leftRs[1], leftRs[0], 1) + leftRs[1];
                int rightCnt = dfs(rightRs[1], rightRs[0], 1) + rightRs[1];
                System.out.println("result >> " + leftCnt + ", " + rightCnt);
                cost += Math.min(leftCnt, rightCnt);
            }
        }
        
        return cost;
    }
}