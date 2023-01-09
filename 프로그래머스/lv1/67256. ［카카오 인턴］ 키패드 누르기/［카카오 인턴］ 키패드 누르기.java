class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] phone = new int[10][2];
        int row = 0, col = 0;
        for (int i = 1; i < phone.length; i++) {
            phone[i] = new int[]{row, col++};
            if(col == 3) {
                row++;
                col = 0;
            }
        }
        phone[0] = new int[]{3, 1};

        StringBuilder sb = new StringBuilder();
        int[] lIdx = {3, 0}, rIdx = {3, 2};
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 3 == 1){
                sb.append("L");
                lIdx = phone[numbers[i]];
            } else if ( numbers[i] != 0 && numbers[i] % 3 == 0) {
                sb.append("R");
                rIdx = phone[numbers[i]];
            }else {
                int[] numberPoint = phone[numbers[i]];
                int lDist = calc(numberPoint, lIdx);
                int rDist = calc(numberPoint, rIdx);

                if (lDist == rDist) {
                    switch (hand.charAt(0)) {
                        case 'r':
                            sb.append("R");
                            rIdx = numberPoint;
                            break;
                        case 'l':
                            sb.append("L");
                            lIdx = numberPoint;
                            break;
                    }
                } else if (lDist > rDist) {
                    sb.append("R");
                    rIdx = numberPoint;
                } else {
                    sb.append("L");
                    lIdx = numberPoint;
                }
            }
        }

        return sb.toString();
    }

    public static int calc(int[] p1, int[] p2) {
        int x = Math.abs(p1[0] - p2[0]);
        int y = Math.abs(p1[1] - p2[1]);
        return x + y;
    }
}