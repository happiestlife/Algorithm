package P4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P4_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String subStr = br.readLine();

        Map<Character, Integer> subStrComp = new HashMap<>();
        analyzeStrComp(subStrComp, subStr, subStr.length());

        Map<Character, Integer> findStrComp = new HashMap<>();
        analyzeStrComp(findStrComp, str, subStr.length());

        int anaStrCnt = 0;
        if(isAnaStr(subStrComp, findStrComp))
            anaStrCnt++;

        for (int i = subStr.length(); i < str.length(); i++) {
            char prevChar = str.charAt(i - subStr.length());
            char nextChar = str.charAt(i);

            if(findStrComp.get(prevChar) <= 1){
                findStrComp.remove(prevChar);
            }else{
                findStrComp.put(prevChar, findStrComp.get(prevChar) - 1);
            }

            if(findStrComp.containsKey(nextChar)){
                findStrComp.put(nextChar, findStrComp.get(nextChar) + 1);
            }else{
                findStrComp.put(nextChar, 1);
            }

            if(isAnaStr(subStrComp, findStrComp))
                anaStrCnt++;
        }

        System.out.println(anaStrCnt);



        br.close();
    }

    private static boolean isAnaStr(Map<Character, Integer> subStrComp, Map<Character, Integer> findStrComp){
        if(subStrComp.size() != findStrComp.size())
            return false;

        for (Character c : subStrComp.keySet()) {
            if(!findStrComp.containsKey(c))
                return false;

            if(subStrComp.get(c) != findStrComp.get(c))
                return false;
        }

        return true;
    }

    private static void analyzeStrComp(Map<Character, Integer> strComp, String str, int len) {
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (strComp.containsKey(c)) {
                strComp.put(c, strComp.get(c) + 1);
            }else{
                strComp.put(c, 1);
            }
        }
    }

}
