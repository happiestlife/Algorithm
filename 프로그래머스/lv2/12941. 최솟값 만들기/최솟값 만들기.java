import java.util.Arrays;

class Solution
{
    public long solution(int []a, int []b)
    {
        // 각 배열의 가장 큰 요소와 가장 작은 요소를 곱해가기
        Arrays.sort(a);
        Arrays.sort(b);

        long rs = 0;
        for(int i = 0; i < a.length; i++){
            rs += (long) a[i] * b[b.length - 1 - i];
        }
        
        return rs;
    }
}