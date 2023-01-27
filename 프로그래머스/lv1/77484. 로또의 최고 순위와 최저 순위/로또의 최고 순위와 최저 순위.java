class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 담청 번호에 대해서 쉽게 찾기 위한 배열 초기화
        boolean[] winNum = new boolean[46];
        for(int i = 0; i < win_nums.length; i++){
            winNum[win_nums[i]] = true;
        }
        
        int zeroCnt = 0, winCnt = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zeroCnt++;
            }
            else if(winNum[lottos[i]]){
                winCnt++;
            }
        }
        
        // 0의 개수를 더하냐 안더하냐에 따라 최저, 최고 순위 구하기
        // 맞는 수가 하나도 없다면 최저, 최고 모두 6위
        int rnk1 = 7 - winCnt;
        int rnk2 = 7 - (winCnt + zeroCnt);
        if(zeroCnt == 6){
            rnk1 = 6;
            rnk2 = 1;
        }else if(winCnt == 0 && zeroCnt == 0){
            rnk1 = 6;
            rnk2 = 6;
        }
        
        return new int[]{rnk2, rnk1};
    }
}