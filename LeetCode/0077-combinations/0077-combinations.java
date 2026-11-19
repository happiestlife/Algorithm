import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            List<Integer> curComps = new ArrayList<>();
            searchAll(result, n, k, curComps, i);
        }

        return result;
    }

    private void searchAll(List<List<Integer>> result, int n, int k, List<Integer> comps, int cur) {
        comps.add(cur);
        if(comps.size() == k) {
            result.add(new ArrayList<>(comps));
            comps.remove(comps.size()-1);
            return;
        }

        for(int i = cur+1; i <= n; i++) {
            searchAll(result, n, k, comps, i);
        }


        comps.remove(comps.size()-1);
    }
}