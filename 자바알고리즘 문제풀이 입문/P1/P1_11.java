import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1_11 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        int rpt = 0;
        char bc = Character.UNASSIGNED;
        for (int i = 0; i < str.length(); i++) {
            /**
             *  if 반복되지 않는 문자
             *   1) 이전의 반복 문자에 대한 처리
             *      (1) 반복횟수가 2 이상이면 문자 옆에 반복횟수 적어주기
             *      (2) 반복횟수 초기화
             *   2) 새로운 문자 적어주기
             *      (1) sb에 문자 추가하기
             *      (2) 반복횟수 하나 증가
             *
             *  if 반복되는 중(이전 문자 == 현재 문자)
             *   1) 반복횟수 하나 증가
             */

            char c = str.charAt(i);
            if(c != bc){
                if(rpt >= 2){
                    sb.append(rpt);
                }
                rpt = 0;

                sb.append(c);
                rpt++;
            }else{
                rpt++;
            }
            bc = c;
        }
        if(rpt >= 2)
            sb.append(rpt);

        System.out.println(sb);

        br.close();
    }
}

