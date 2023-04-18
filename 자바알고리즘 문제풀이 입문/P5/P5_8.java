package P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P5_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        // [0] : 환자 순서, [1] : 환자 위험도
        Queue<int[]> patient = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int risk = Integer.parseInt(stk.nextToken());

            patient.add(new int[]{i, risk});
            maxHeap.add(risk);
        }

        int cnt = 1;
        while (!patient.isEmpty()) {
            int[] patientInfo = patient.peek();
            // 현재 환자가 가장 위험도가 높은 경우
            if(patientInfo[1] == maxHeap.peek()){
                maxHeap.poll();
                patient.poll();
                int patientOrder = patientInfo[0];
                if(patientOrder == m){
                    break;
                }

                cnt++;
            }
            else{
                patient.add(patient.poll());
            }

        }

        System.out.println(cnt);

        br.close();
    }
}
