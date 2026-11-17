import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String curStr = strs[i];
            String curAscStr = getAscString(curStr);

            if(!map.containsKey(curAscStr)) {
                map.put(curAscStr, new ArrayList<>());
            } 
            List<String> keyComps = map.get(curAscStr);
            keyComps.add(curStr);
            map.put(curAscStr, keyComps);
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> comps : map.values()) {
            result.add(comps);
        }

        return result;
    }

    private String getAscString(String str) {
        char[] comps = new char[str.length()];
        for(int i = 0; i < comps.length; i++) {
            comps[i] = str.charAt(i);
        }

        Arrays.sort(comps);
        return new String(comps);
    }
}