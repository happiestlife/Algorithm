class Solution {
    
    // [0] : 0의 개수, [1] : 1의 개수
    static int[] rs = new int[2];
    static int[][] arr;
    
    public int[] solution(int[][] array) {
        arr = array;
        recur(arr.length, 0, 0);

        return rs;
    }
    
    public static void recur(int len, int x, int y) {
        if(len == 1){
            rs[arr[x][y]]++;
            return;
        }

        // 1. 모두 같은지 검사
        if (canCompress(len, x, y)) {
            // 2. 같으면 압축
            rs[arr[x][y]]++;
        }
        else{
            // 3. 다르면 4분위로 나워서 다시 검사
            int halfLen = len / 2;
            recur(halfLen, x, y);
            recur(halfLen, x + halfLen, y);
            recur(halfLen, x, y + halfLen);
            recur(halfLen, x + halfLen, y + halfLen);
        }
    }
    
    public static boolean canCompress(int len, int x, int y) {
        int num = arr[x][y];
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if(arr[i][j] != num){
                    return false;
                }
            }
        }

        return true;
    }

    public static void makeResult(int len, int x, int y) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                rs[arr[i][j]]++;
            }
        }
    }
}