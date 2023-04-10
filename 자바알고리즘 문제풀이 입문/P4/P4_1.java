package P4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P4_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        System.out.println(maxHeap.peek().getKey());

        br.close();
    }
}
