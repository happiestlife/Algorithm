class Solution {
    public int solution(int n) {
        int s = 1, e = 1, cur = 1, rs = 0;
        while (true) {
            // 종료조건
            // 1. s나 e가 n 이상이 되었을 때
            // 2. s와 e가 역전 되었을 때
            if (s > e) {
                break;
            }

            // cur < n?
            //  - 끝 포인터 증가, cur에 현재 끝포인터 값 더하기
            // cur > n?
            //  - cur에 시작 포인터 값 빼기, 시작 포인터 증가
            // cur == n?
            //  - 결과 한개 증가 & 끝 포인터 한개 증가시키기
            if (cur < n) {
                if(e == n)
                    break;
                cur += ++e;
            } else if (cur > n) {
                cur -= s++;
            } else {
                rs++;
                cur += ++e;
            }
        }

        return rs;
    }
}