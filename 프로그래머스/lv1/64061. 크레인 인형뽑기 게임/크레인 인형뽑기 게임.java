import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer>[] b = new Stack[board.length];
        for (int i = b.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (b[j] == null)
                    b[j] = new Stack<>();

                if(board[i][j] != 0)
                    b[j].push(board[i][j]);
            }
        }

        int rs = 0;
        Stack<Integer> bucket = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            if(b[moves[i]-1].isEmpty())
                continue;

            int doll = b[moves[i]-1].pop();
            if(!bucket.isEmpty() && bucket.peek() == doll){
                bucket.pop();
                rs += 2;
            }else{
                bucket.push(doll);
            }
        }

        return rs;
    }
}