import java.util.Arrays;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;

        int[] numerDvisor = new int[numer + 1];
        int[] denomDvisor = new int[denom + 1];

        int ntmp = numer;
        for (int i = 2; i <= ntmp; i++) {
            while(ntmp % i == 0){
                numerDvisor[i]++;
                ntmp /= i;
            }
        }

        int dtmp = denom;
        for (int i = 2; i <= dtmp; i++) {
            while(dtmp % i == 0){
                denomDvisor[i]++;
                dtmp /= i;
            }
        }

        int n = 1, d = 1;
        int len = numerDvisor.length > denomDvisor.length ? denomDvisor.length : numerDvisor.length;
        for (int i = 2; i < len; i++) {
            if(numerDvisor[i] >= denomDvisor[i]){
                numerDvisor[i] -= denomDvisor[i];
                for (int j = 0; j < numerDvisor[i]; j++) {
                    n *= i;
                }
            }else{
                denomDvisor[i] -= numerDvisor[i];
                for (int j = 0; j < denomDvisor[i]; j++) {
                    d *= i;
                }
            }
            numerDvisor[i] = 0;
            denomDvisor[i] = 0;
        }

        if(numerDvisor.length > denomDvisor.length){
            for (int i = denomDvisor.length; i < numerDvisor.length; i++) {
                for (int j = 0; j < numerDvisor[i]; j++) {
                    n *= i;
                }
            }
        } else if (numerDvisor.length < denomDvisor.length) {
            for (int i = numerDvisor.length; i < denomDvisor.length; i++) {
                for (int j = 0; j < denomDvisor[i]; j++) {
                    d *= i;
                }
            }
        }

        
        return new int[]{n, d};
    }
}