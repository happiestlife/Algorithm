import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 전체 학생 중 어떤 학생이 여분을 가져왔는지 체크
        boolean[] rsrv = new boolean[n];
        for(int i = 0; i < reserve.length; i++){
            rsrv[reserve[i]-1] = true;
        }

        // 정답은 전체 학생수에서 분실한 사람의 수를 뺀 값
        int rs = n - lost.length;
        boolean[] isSame = new boolean[n];
        // 자기 자신이 여분을 가지고 있지만 분실한 경우를 먼저 처리
        // -> 자신보다 다른 사람에게 먼저 빌려주는 것 방지
        for(int i = 0; i < lost.length; i++){
            if(rsrv[lost[i]-1]){
                rs++;
                rsrv[lost[i]-1] = false;
                isSame[lost[i]-1] = true;
            }
        }

        // 오름차순/내림차순으로 진행하여 나보다 작은/큰 학생의 여분을 빌리도록 한다. (greedy)
        Arrays.sort(lost);
        for(int i = 0; i < lost.length; i++){
            int lostIdx = lost[i]-1;
            if(isSame[lostIdx])
                continue;

            // 이전 번호의 학생이 여유분을 가지고 있는지 확인
            if(lostIdx > 0 && rsrv[lostIdx-1]){
                rs++;
                rsrv[lostIdx-1] = false;
            }
            // 다음 번호의 학생이 여유분을 가지고 있는지 확인
            else if(lostIdx < rsrv.length-1 && rsrv[lostIdx+1]){
                rs++;
                rsrv[lostIdx+1] = false;
            }
        }
        
        return rs;
    }
}