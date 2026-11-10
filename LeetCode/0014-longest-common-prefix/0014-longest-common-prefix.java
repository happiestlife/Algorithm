class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 가장 작은 길이의 부분 문자열 찾기 -> 최대 탐색 횟수
        int minLength = 201;
        for(int i = 0; i < strs.length; i++) {
            String curStr = strs[i];
            minLength = Math.min(minLength, curStr.length());
        }

        // 각 문자열에서 앞자리 하나씩 비교해서 다른게 나온다면 break;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < minLength; i++) {
            Set<Character> curChars = new HashSet<>(strs.length);
            for(int j = 0; j < strs.length; j++) {
                char curStringChar = strs[j].charAt(i);
                curChars.add(curStringChar);
            }

            if(curChars.size() > 1) break;
            else sb.append(strs[0].charAt(i));
        }

        return sb.toString();
    }
}