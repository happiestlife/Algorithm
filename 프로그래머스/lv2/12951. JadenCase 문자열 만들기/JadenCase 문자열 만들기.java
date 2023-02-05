class Solution {
    public String solution(String s) {
        
        // 모든 알파벳을 소문자로 만들기
        StringBuilder rs = new StringBuilder(s.toLowerCase());
        // 첫번째 단어인지 아닌지를 판단하기 위함
        boolean isFirstCharacter = true;
        for(int i = 0; i < rs.length(); i++){
            char c = rs.charAt(i);
            if(c == ' '){
                isFirstCharacter = true;
            }
            else if(isFirstCharacter){
                rs.setCharAt(i, Character.toUpperCase(c));
                isFirstCharacter = false;
            }
        }
        
        return rs.toString();
    }
}