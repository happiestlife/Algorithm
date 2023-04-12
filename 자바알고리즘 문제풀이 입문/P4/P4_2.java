package P4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P4_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        Map<Character, Integer> str1Comp = new HashMap<>();
        Map<Character, Integer> str2Comp = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            insertComp(c1, str1Comp);
            char c2 = str2.charAt(i);
            insertComp(c2, str2Comp);
        }

        boolean isSame = true;
        for (Character key : str1Comp.keySet()) {
            if (!str2Comp.containsKey(key) || str1Comp.get(key) != str2Comp.get(key)) {
                isSame = false;
                break;
            }
        }

        if(isSame){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }


        br.close();
    }

    private static void insertComp(char c, Map<Character, Integer> map) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        }else{
            map.put(c, 1);
        }
    }
}
