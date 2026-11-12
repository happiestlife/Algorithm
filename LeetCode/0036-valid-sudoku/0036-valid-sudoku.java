import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 1. 가로 & 새로 검사
        boolean isValid = true;
        for(int i = 0; i < board.length; i++) {
            int x = i, y = i;
            Set<Character> xLineComps = new HashSet<>();
            Set<Character> yLineComps = new HashSet<>();
            for(int j = 0; j < board[i].length; j++) {
                char nextXLineComp = board[x][j];
                char nextYLineComp = board[j][y];

                if(xLineComps.contains(nextXLineComp) || yLineComps.contains(nextYLineComp)) {
                    isValid = false;
                    break;
                }

                if(nextXLineComp != '.')
                    xLineComps.add(nextXLineComp);
                if(nextYLineComp != '.')
                    yLineComps.add(nextYLineComp);
            }

            if(!isValid) return false;
        }

        // 3. 사각형 검사
        for(int i = 0; i < board.length / 3; i++) {
            for(int j = 0; j < board[i].length / 3; j++) {

                Set<Character> comps = new HashSet<>();
                for(int x = 3 * i; x < 3 * (i+1); x++) {
                    for(int y = 3 * j; y < 3 * (j+1); y++) {
                        char c = board[x][y];
                        if(comps.contains(c)) {
                            return false;
                        }
                        
                        if(c != '.') comps.add(c);
                    }
                }

            }
        }

        return true;
    }
}