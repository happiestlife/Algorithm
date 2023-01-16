class Solution {
    public int[] solution(int n, String[] words) {
        Dictionary d = new Dictionary(' ', false);

        int cnt = 1;
        int order = 0;
        boolean isFail = false;
        char beforeChar = ' ';
        for (int i = 0; i < words.length; i++) {
            String s = words[i];

            if (i > 0 && beforeChar != s.charAt(0)) {
                isFail = true;
                break;
            }

            // 이미 존재하는 단어인지 검사하기
            // 있다면 실패, 없다면 새로 생성하기
            Dictionary td = d;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if(td.nextChar[c-'a'] == null)
                    td.nextChar[c - 'a'] = new Dictionary(c, false);
                td = td.nextChar[c - 'a'];

                // 문자열의 마지막 문자이고 해당 단어가 이미 나왔는지 안나왔는지 검사
                if (j == s.length() - 1) {
                    if(td.isWord) {
                        isFail = true;
                        break;
                    }else{
                        td.isWord = true;
                    }
                }
            }

            if (isFail) {
                break;
            }

            // 실패하지 않았다면 cnt와 order 계산하기
            order++;
            if(order % n == 0){
                cnt++;
                order = 0;
            }

            beforeChar = s.charAt(s.length() - 1);
        }
        
        int rs[];
        if(isFail)
            rs = new int[]{order+1, cnt};
        else
            rs = new int[]{0, 0};
        
        return rs;
    }
    
    static class Dictionary{
        char c;
        Dictionary[] nextChar;
        boolean isWord;

        public Dictionary(char c, boolean isWord) {
            this.c = c;
            this.nextChar = new Dictionary[26];
            this.isWord = isWord;
        }
    }
}