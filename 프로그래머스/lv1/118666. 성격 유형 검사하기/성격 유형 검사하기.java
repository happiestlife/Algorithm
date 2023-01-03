import java.io.IOException;

class Solution {
    
    static final char[][] character = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
    static final int[] score = {-1, 3, 2, 1, 0, 1, 2, 3};
    
    public String solution(String[] survey, int[] choices) {
        int rs[][] = new int[4][2];

        for (int i = 0; i < survey.length; i++) {
            int posX = findPos(survey[i]);
            int posY = 0;
            if (survey[i].charAt(0) > survey[i].charAt(1)) {
                posY = 1;
            }

            int scr = score[choices[i]];
            if (choices[i] > 4) {
                if(posY == 0)
                    posY = 1;
                else
                    posY = 0;
            }

            rs[posX][posY] += scr;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rs.length; i++) {
            if (rs[i][0] < rs[i][1]) {
                sb.append(character[i][1]);
            } else {
                sb.append(character[i][0]);
            }
        }

        return sb.toString();
    }
    
        public static int findPos(String srvy) {
        char c = srvy.charAt(0);
        if (c == character[0][0] || c == character[0][1]) {
            return 0;
        } else if (c == character[1][0] || c == character[1][1]) {
            return 1;
        } else if (c == character[2][0] || c == character[2][1]) {
            return 2;
        } else {
            return 3;
        }
    }
}