import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minh = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            int d = Integer.parseInt(br.readLine());
            if(maxh.size() == minh.size()){
                if(!minh.isEmpty() && minh.peek() < d) {
                    maxh.add(minh.poll());
                    minh.add(d);
                }
                else maxh.add(d);
            }else{
                if(!maxh.isEmpty() && maxh.peek() > d) {
                    minh.add(maxh.poll());
                    maxh.add(d);
                }
                else minh.add(d);
            }

            bw.write(maxh.peek()+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}