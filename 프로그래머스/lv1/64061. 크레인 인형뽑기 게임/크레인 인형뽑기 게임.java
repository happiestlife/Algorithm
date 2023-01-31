import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // board의 첫번째 []에서 인덱스의 오름차순에 대해 보드의 윗부분부터 시작하기 때문에 
        // stack에 거꾸로 넣기 위해선 끝에서부터 넣기
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
            // 해당 라인에 아무것도 없으면 바구니에 아무것도 담지 못한다. 
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