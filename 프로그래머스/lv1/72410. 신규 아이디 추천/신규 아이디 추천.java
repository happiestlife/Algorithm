class Solution {
    public String solution(String new_id) {
        // 소문자로 치환
        new_id = new_id.toLowerCase();

        // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        new_id = new_id.replaceAll("[^0-9a-z-_.]", "");

        // 문자열의 2번 이상 연속된 . 제거
        new_id = new_id.replaceAll("[.]{2,}", ".");

        // 문자열의 처음이나 끝에 .이 있다면 제거
        new_id = new_id.replaceAll("^[.]", "");
        new_id = new_id.replaceAll("[.]$", "");

        // 빈 문자열이라면 a 대입
        if (new_id.length() == 0) {
            new_id = new_id.replaceAll("^$", "a");
        } 
        // 문자열의 길이가 15 초과라면 15길이까지로 자르고 마지막에 .이 존재한다면 제거
        else if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15)
                            .replaceAll("[.]$", "");
        }

        // 문자열 길이가 2 이하라면 문자열의 마지막 문자를 문자열의 길이가 3일 될때까지 붙이기
        if (new_id.length() < 3) {
            StringBuilder sb = new StringBuilder(new_id);
            char c = new_id.charAt(new_id.length() - 1);
            while (sb.length() < 3) {
                sb.append(c);
            }

            new_id = sb.toString();
        }

        return new_id;
    }
}