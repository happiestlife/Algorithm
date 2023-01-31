import java.io.IOException;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int userLen = id_list.length;
        // key : 신고당한 유저 아이디, value : 해당 유저를 신고한 아이디 목록
        //                                  (중복이 가능하기 때문에 쉬운 구현을 위한 set 사용) 
        HashMap<String, HashSet<Integer>> reportId = new HashMap<>();

        // key : 유저 아이디, value : 유저의 번호
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
            // 해당 유저를 이미 신고했다면 아무것도 진행하지 않음
            if (rptUsers != null && rptUsers.contains(rsInd.get(reportUser))) {
                continue;
            }else{
                // 해당 유저를 신고한 목록에 신고를 진행한 유저의 아이디 넣기
                if(rptUsers == null)
                    reportId.put(reportedUser, new HashSet<>());
                reportId.get(reportedUser).add(rsInd.get(reportUser));
            }
        }

        // 각 유저가 신고당한 횟수를 조사
        // k번 이상이면 문자 발송
        int[] rs = new int[userLen];
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