import java.util.*;

class Node {
    int sum;
    List<Integer> comps;

    public Node(int sum, List<Integer> comps) {
        this.sum = sum;
        this.comps = comps;
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, new ArrayList<>()));
        while(!q.isEmpty()) {
            Node curNode = q.poll();

            for(int i = 0; i < candidates.length; i++) {
                int candidate = candidates[i];
                int candidateSum = curNode.sum + candidate;
                if(candidateSum == target) {
                    List<Integer> candidateComps = new ArrayList<>(curNode.comps);
                    candidateComps.add(candidate);

                    if(isExistResult(result, candidateComps)) continue;
                    
                    result.add(new ArrayList<>(candidateComps));
                } else if(candidateSum < target) { 
                    List<Integer> candidateComps = new ArrayList<>(curNode.comps);
                    candidateComps.add(candidate);

                    q.add(new Node(candidateSum, candidateComps));
                }
            }
        }


        return result;
    }

    private boolean isExistResult(List<List<Integer>> results, List<Integer> compare) {
        for(List<Integer> result : results) {
            if(compare.size() != result.size()) continue;

            Collections.sort(compare);
            Collections.sort(result);

            boolean isSame = true;
            for(int i = 0; i < result.size(); i++) {
                int resultComp = result.get(i);
                int compareComp = compare.get(i);

                if(resultComp != compareComp) {
                    isSame = false;
                    break;
                }
            }

            if(isSame) return true;
        }

        return false;
    }
}