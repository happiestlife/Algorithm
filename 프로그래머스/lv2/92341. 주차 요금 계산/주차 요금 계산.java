import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        final String OUT = "OUT";
        final String IN = "IN";

        // 차가 언제들어왔는지 저장하기 위한 Map
        Map<Integer, int[]> inTimeMap = new HashMap<>();

        // 차량별 총 이용시간을 나타내는 맵
        // 키 : 차종, 값 : 이용한 시간 (분단위)
        Map<Integer, Integer> useTimeMap = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            // 문자열 파싱
            StringTokenizer stk = new StringTokenizer(records[i]);
            String[] token = stk.nextToken().split(":");
            int minute = Integer.parseInt(token[0]);
            int second = Integer.parseInt(token[1]);

            int carNum = Integer.parseInt(stk.nextToken());

            String flag = stk.nextToken();

            // 차량이 들어오는건지 나가는건지 검사
            if (flag.equals(IN)) {
                inTimeMap.put(carNum, new int[]{minute, second});
            } else {
                // 총 사용시간 (분단위) 계산
                int[] inTime = inTimeMap.get(carNum);
                Calendar time = Calendar.getInstance();
                time.set(Calendar.HOUR_OF_DAY, minute - inTime[0]);
                time.set(Calendar.MINUTE, second - inTime[1]);

                int useHour = time.get(Calendar.HOUR_OF_DAY);
                int useMinute = time.get(Calendar.MINUTE);

                int totalMinute = useHour * 60 + useMinute;

                // 총 사용시간에 넣기
                if (useTimeMap.containsKey(carNum)) {
                    useTimeMap.put(carNum, useTimeMap.get(carNum) + totalMinute);
                } else {
                    useTimeMap.put(carNum, totalMinute);
                }

                // 입차만 하고 출차를 하지 않는 차량을 검사하기 위해 출차한 차량 삭제
                inTimeMap.remove(carNum);
            }
        }

        // 입차만 한 차량 계산
        for (Map.Entry<Integer, int[]> entry : inTimeMap.entrySet()) {
            int carNum = entry.getKey();

            // 총 사용시간 (분단위) 계산
            int[] inTime = inTimeMap.get(carNum);
            Calendar time = Calendar.getInstance();
            time.set(Calendar.HOUR_OF_DAY, 23 - inTime[0]);
            time.set(Calendar.MINUTE, 59 - inTime[1]);

            int useHour = time.get(Calendar.HOUR_OF_DAY);
            int useMinute = time.get(Calendar.MINUTE);

            int totalMinute = useHour * 60 + useMinute;

            // 총 사용시간에 넣기
            if (useTimeMap.containsKey(carNum)) {
                useTimeMap.put(carNum, useTimeMap.get(carNum) + totalMinute);
            } else {
                useTimeMap.put(carNum, totalMinute);
            }
        }

        List<int[]> feeList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : useTimeMap.entrySet()) {
            int totalMinute = entry.getValue();

            totalMinute -= fees[0];
            int feeCnt = (int) Math.ceil((double) totalMinute / fees[2]);
            if(feeCnt < 0)
                feeCnt = 0;
            int totalFee = fees[1] + feeCnt * fees[3];
            feeList.add(new int[]{entry.getKey(), totalFee});
        }

        Collections.sort(feeList, Comparator.comparingInt(arr -> arr[0]));
        int[] rs = new int[feeList.size()];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = feeList.get(i)[1];
        }
        return rs;
    }
}