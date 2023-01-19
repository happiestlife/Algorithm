import java.util.*;

public class Solution {
    public int solution(int n) {
        int move = 0;
        while(n >= 1){
            if(n % 2 == 1)
                move++;

            n /= 2;
        }

        return move;
    }
}