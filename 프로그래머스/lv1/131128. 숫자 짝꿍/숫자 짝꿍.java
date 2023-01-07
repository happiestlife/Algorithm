class Solution {
    public String solution(String x, String y) {
        int[] xElement = new int[10];
        int[] yElement = new int[10];

        cal(x, xElement);
        cal(y, yElement);

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int xEleCnt = xElement[i];
            int yEleCnt = yElement[i];

            // 2개의 문자열 중 하나에서도 요소가 없으면 공통이 없는 것이기 떄문에 continue
            if(xEleCnt == 0 || yEleCnt == 0)
                continue;

            // 같은 요소에 대해서만 반복하기
            int len = yEleCnt;
            if (xEleCnt < yEleCnt) {
                len = xEleCnt;
            }

            // 00000과 같이 0만으로 구성된 경우 0한번만 넣기
            if(i == 0 && sb.length() == 0)
                len = 1;

            for (int j = 0; j < len; j++) {
                sb.append(i);
            }
        }

        if(sb.length() == 0)
            sb.append("-1");

        return sb.toString();
    }
    
        public static void cal(String x, int[] element) {
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            for (int j = 0; j < 10; j++) {
                if (Character.getNumericValue(c) == j) {
                    element[j]++;
                    break;
                }
            }
        }
    }
}