import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        long a = Long.parseLong(stk.nextToken());
        long b = Long.parseLong(stk.nextToken());

        Map<Long, Integer> dp = new HashMap<>();
        Queue<Long> q = new LinkedList<>();
        q.add(a);
        dp.put(a, 1);
        if(a == b) q.clear();
        while (!q.isEmpty()) {
            long num = q.poll();

            boolean findAnswer = false;
            for (int i = 0; i < 2; i++) {
                long calcNum = getNum(i, num);
                if (calcNum <= b && !dp.containsKey(calcNum)) {
                    dp.put(calcNum, dp.get(num) + 1);
                    if(calcNum == b){
                        findAnswer = true;
                        break;
                    }

                    q.add(calcNum);
                }
            }

            if(findAnswer){
                break;
            }
        }

        if(dp.containsKey(b)){
            System.out.println(dp.get(b));
        }
        else{
            System.out.println(-1);
        }

        br.close();
    }

    public static long getNum(int idx, long num){
        if(idx == 0){
            return num * 2;
        }
        else{
            return num * 10 + 1;
        }
    }
}