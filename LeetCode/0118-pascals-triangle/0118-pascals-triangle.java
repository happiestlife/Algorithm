import java.util.*;


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            List<Integer> rowResult = new ArrayList<>(i + 1);
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    rowResult.add(1);
                    continue;
                }

                if(i > 0) {
                    List<Integer> preRowResult = result.get(i - 1);
                    int newNum = preRowResult.get(j - 1) + preRowResult.get(j);
                    rowResult.add(newNum);
                }
            }
            result.add(rowResult);
        }

        return result;
    }
}