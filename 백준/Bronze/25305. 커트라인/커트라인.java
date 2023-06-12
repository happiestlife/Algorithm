import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];
        int max = 0;
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
            max = Math.max(max, arr[i]);
        }

        // 1. 버블 정렬
//        for(int i = 0; i < arr.length - 1; i++){
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if(arr[j] > arr[j + 1]){
//                    int tmp  = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = tmp;
//                }
//            }
//        }

        // 2. 선택 정렬
//        for(int i = 0; i < arr.length - 1; i++){
//            int minIdx = i;
//            for(int j = i; j < arr.length; j++){
//                if(arr[minIdx] > arr[j]){
//                    minIdx = j;
//                }
//            }
//
//            if(minIdx != i){
//                int tmp = arr[i];
//                arr[i] = arr[minIdx];
//                arr[minIdx] = tmp;
//            }
//        }

        // 3. 삽입 정렬
//        for(int i = 1; i < arr.length; i++){
//            int j = i;
//            while (j > 0 && arr[j - 1] > arr[j]) {
//                int tmp = arr[j - 1];
//                arr[j - 1] = arr[j];
//                arr[j] = tmp;
//                j--;
//            }
//        }

        // 4. 기수 정렬
        List<Integer>[] list = new LinkedList[10];
        for(int i = 0; i < list.length; i++){
            list[i] = new LinkedList();
        }

        int len = 1;
        while(max / 10 > 0){
            max /= 10;
            len++;
        }

        int digit = 10;
        for(int i = 0; i < len; i++){
            int divisor = digit / 10;
            for(int j = 0; j < arr.length; j++){
                int idx = (arr[j] % digit) / divisor;
                list[idx].add(arr[j]);
            }

            int idx = 0;
            for(int j = 0; j < list.length; j++){
                for (int l = 0; l < list[j].size(); l++) {
                    arr[idx++] = list[j].get(l);
                }
            }

            digit *= 10;
            for(int j = 0; j < list.length; j++){
                list[j].clear();
            }

        }

        System.out.println(arr[arr.length - k]);

        br.close();
    }
}