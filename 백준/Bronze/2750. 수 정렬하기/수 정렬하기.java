import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
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
        for(int i = 1; i < arr.length; i++){
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int tmp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = tmp;
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb.toString());

        br.close();
    }
}