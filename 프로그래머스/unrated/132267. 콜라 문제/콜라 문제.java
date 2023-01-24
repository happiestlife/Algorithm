class Solution {
    public int solution(int a, int b, int n) {
        int rs = 0;
        while(n / a > 0){
            rs += (int)(n / a) * b;
            n = (int)(n / a) * b + n % a;
        }
        
        return rs;
    }
}