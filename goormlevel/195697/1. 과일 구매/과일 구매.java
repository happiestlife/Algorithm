import java.io.*;
import java.util.*;

public class Main {

    static class Fruit implements Comparable<Fruit> {
        int p;
        double c;
        double ratio;

        Fruit(int p, double c) {
            this.p = p;
            this.c = c;
            this.ratio = c / p;
        }

        @Override
        public int compareTo(Fruit o) {
            return Double.compare(o.ratio, this.ratio);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        Fruit[] fruits = new Fruit[n];

        for(int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            fruits[i] = new Fruit(p, c);
        }

        Arrays.sort(fruits);

        double result = 0;
        for(Fruit fruit : fruits) {
            long buy = Math.min(fruit.p, k);
            result += buy * fruit.ratio;
            k -= buy;
            if(k == 0) break;
        }

        System.out.println((long)result);
    }
}