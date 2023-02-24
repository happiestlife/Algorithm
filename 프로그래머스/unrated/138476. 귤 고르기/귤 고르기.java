import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int type;
        int count;

        public Node(int type, int count) {
            this.type = type;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return o.count - this.count;
        }
    }
    
    public int solution(int k, int[] tangerine) {
        // 귤 타입 개수 세기
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            int type = tangerine[i];
            if (map.containsKey(type)) {
                map.put(type, map.get(type) + 1);
            } else {
                map.put(type, 1);
            }
        }

        // 많은 것들부터 넣기
        List<Node> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list);

        int rs = 0;
        int idx = 0;
        while (idx < list.size()) {
            k -= list.get(idx++).count;
            rs++;

            if(k <= 0)
                break;
        }
        
        return rs;
    }
}