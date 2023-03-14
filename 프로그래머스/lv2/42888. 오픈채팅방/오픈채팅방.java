import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        final char ENTER = 'E';
        final char LEAVE = 'L';
        final char CHANGE = 'C';

        final int IN_MSG = 0;
        final int OUT_MSG = 1;
        final String[] MSG_FORMAT = {"%s님이 들어왔습니다.", "%s님이 나갔습니다."};

        // key : 아이디, value : 닉네임
        Map<String, String> idToNickNameMap = new HashMap<>();
        // [0] : 아이디, [1] : 메세지 타입 (IN_MSG, OUT_MSG)
        List<Object[]> msg = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            // 문자열 파싱
            StringTokenizer stk = new StringTokenizer(record[i]);
            char type = stk.nextToken().charAt(0);
            String id = stk.nextToken();
            String nickname = "";
            if(type != LEAVE)
                nickname = stk.nextToken();

            // 행동 타입에 따라 다르게 행동하기
            switch(type){
                case ENTER:
                    msg.add(new Object[]{id, IN_MSG});
                    idToNickNameMap.put(id, nickname);
                    break;

                case LEAVE:
                    msg.add(new Object[]{id, OUT_MSG});
                    break;

                case CHANGE:
                    idToNickNameMap.put(id, nickname);
                    break;
            }
        }

        String[] rs = new String[msg.size()];
        for (int i = 0; i < rs.length; i++) {
            Object[] msgData = msg.get(i);
            String id = (String) msgData[0];
            String nickname = idToNickNameMap.get(id);
            int msgType = (Integer) msgData[1];

            rs[i] = String.format(MSG_FORMAT[msgType], nickname);
        }
        
        return rs;
    }
}