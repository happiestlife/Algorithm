import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curComps = new ArrayList<>(candidates.length);
        searchAll(result, curComps, candidates, 0, target, false); 

        return result;
    }

    private void searchAll(List<List<Integer>> result, List<Integer> curComps, int[] candidates, int idx, int target, boolean prevSelected) {
        boolean isSameResultWithPrev = idx > 0 && !prevSelected && candidates[idx] == candidates[idx-1];

        // 현재 숫자를 포함하거나 포함하지 않거나
        // 1. 포함
        if(!isSameResultWithPrev) {
            curComps.add(candidates[idx]);
            int curSum = getSum(curComps);
            if(curSum == target) {
                result.add(new ArrayList<>(curComps));
                curComps.remove(curComps.size()-1);
                return;
            } else if(curSum > target) {
                curComps.remove(curComps.size()-1);
                return;
            } else {
                if(idx+1 < candidates.length) searchAll(result, curComps, candidates, idx+1, target, true);
            }
            curComps.remove(curComps.size()-1);
        }
        // 2. 미포함
        // 다음 Idx로 넘어감
        if(idx+1 < candidates.length) searchAll(result, curComps, candidates, idx+1, target, false);
        return;
    }

    private int getSum(List<Integer> comps) {
        int sum = 0;
        for(int comp : comps) {
            sum += comp;
        }

        return sum;
    }

}