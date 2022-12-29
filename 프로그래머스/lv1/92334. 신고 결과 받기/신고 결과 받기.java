import java.io.IOException;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int userLen = id_list.length;
        HashMap<String, HashSet<Integer>> reportId = new HashMap<>();

        int[] rs = new int[userLen];
        HashMap<String, Integer> rsInd = new HashMap<>();
        for (int i = 0; i < userLen; i++) {
            rsInd.put(id_list[i], i);
        }

        StringTokenizer stk;
        for (int i = 0; i < report.length; i++) {
            stk = new StringTokenizer(report[i]);
            String reportUser = stk.nextToken();
            String reportedUser = stk.nextToken();

            HashSet<Integer> rptUsers = reportId.get(reportedUser);
            if (rptUsers != null && rptUsers.contains(rsInd.get(reportUser))) {
                continue;
            }else{
                if(rptUsers == null)
                    reportId.put(reportedUser, new HashSet<>());
                reportId.get(reportedUser).add(rsInd.get(reportUser));
            }
        }

        for (String s : reportId.keySet()) {
            if (reportId.get(s).size() >= k) {
                for (Object rptUser : reportId.get(s).toArray()) {
                    rs[(int)rptUser]++;
                }
            }
        }
        
        return rs;
    }
}