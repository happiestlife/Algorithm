import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);

        // data[] = 스테이지
        // data[][0] = 해당 스테이지에 도달한 사람수, data[][1] = 도전하는 사람수, data[][2] = 스테이지 Num
        int[][] data = new int[N+1][3];

        // 각 스테이지를 깨고 있는 사람들수 구하기
        for(int i = 0; i < stages.length; i++){
            data[stages[i]-1][1]++;
        }

        // 각 스테이지에 도달한 사람들수 구하기 && 구해진 데이터를 바탕으로 실패율이 높은 데이터에 넣기
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            long next = (long)o2[1]*o1[0];
            long prev = (long)o1[1]*o2[0];
            if(next == prev){
                return o1[2] - o2[2];
            }else{
                // double 형이기 때문에 int형으로 강제형변환 해주면 오류 발생 가능
                double flag = next - prev;
                if(flag < 0){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        int prevSuccessor = 0;
        for(int i = 0; i < data.length-1; i++){
            data[i][0] = stages.length - prevSuccessor;
            prevSuccessor += data[i][1];

            heap.add(new int[]{data[i][0], data[i][1], i});
        }

        int[] rs = new int[N];
        for(int i = 0; i < rs.length; i++){
            rs[i] = heap.poll()[2]+1;
        }
        
        return rs;
    }
}