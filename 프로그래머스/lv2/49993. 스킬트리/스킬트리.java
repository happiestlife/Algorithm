import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        // 사용자가 찍은 스킬 트리의 요소들이 스킬 트리 조건의 요소에 포함되는지 검사하기 위한 Set
        Set<Character> set = new HashSet<>();
        // 스킬 트리 조건의 요소라면, 반드시 해당 가장 먼저 배워야 하는 스킬 트리가 나와야 함
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < skill.length(); i++) {
            char c = skill.charAt(i);
            queue.add(c);
            set.add(c);
        }

        int rs = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            String str = skill_trees[i];
            Queue<Character> q = new LinkedList<>(queue);

            boolean isFail = false;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                // 필요한 스킬 트리에 포함되지 않으면 검사 필요 X
                if(!set.contains(c))
                    continue;
                
                // 스킬 트리 조건의 요소라면 반드시 첫번째로 마스터해야 하는 스킬이어야 한다. 
                if(q.poll() != c){
                    isFail = true;
                    break;
                }

                // 스킬을 모두 다 배웠다면 어떤 다른 스킬을 배워도 상관 X
                if(q.isEmpty())
                    break;
            }

            if (!isFail) {
                rs++;
            }
        }
        
        return rs;
    }
}