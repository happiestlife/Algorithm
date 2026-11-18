class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0, tIdx = 0;
        while(sIdx < s.length() && tIdx < t.length()) {
            char tChar = t.charAt(tIdx);
            char sChar = s.charAt(sIdx);
            if(tChar == sChar) {
                sIdx++;
            }
            tIdx++;
        }

        return sIdx == s.length();
    }
}