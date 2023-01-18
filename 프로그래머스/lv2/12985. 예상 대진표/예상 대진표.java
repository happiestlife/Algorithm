class Solution
{
    public int solution(int n, int a, int b)
    {
        // 최대 라운드 수 구하기
        int maxRound = 1;
        int num = 2;
        while(num < n){
            num *= 2;
            maxRound++;
        }

        int s = 1, e = n;
        while (true) {
            int mid = (s + e) / 2;

            // 현재 라운드의 반쪽에 대해 a와 b가 같은 라운드인지 검사하기 위한 변수
            boolean isAInRound = s <= a && a <= mid;
            boolean isBInRound = s <= b && b <= mid;

            // 있다면 해당 라운드로 이동하기
            if (isAInRound && isBInRound) {
                e = mid;
            } else if (!isAInRound && !isBInRound) {
                s = mid + 1;
            }
            // 현재라 라운드의 아랫 라운드부터 a와 b가 다른 라운드라면 현재 라운드가 정답
            else {
                break;
            }

            maxRound--;
        }
        
        return maxRound;
    }
}