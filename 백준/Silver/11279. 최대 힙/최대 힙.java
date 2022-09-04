import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        MaxHeap heap = new MaxHeap();
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0)
                bw.write(heap.pop() + "\n");
            else
                heap.insert(num);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

class MaxHeap {
    private List<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        heap.add(-1);
    }

    void insert(int num) {
        heap.add(num);

        int ind = heap.size() - 1;
        while (ind > 1 && heap.get(ind) > heap.get(ind / 2)) {
            int tmp = heap.get(ind);
            heap.set(ind, heap.get(ind/2));
            heap.set(ind/2, tmp);

            ind /= 2;
        }
    }

    int pop() {
        if(heap.size() == 1)
            return 0;

        int rs = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int ind = 1;
        while (ind * 2 < heap.size()) {
            if (ind * 2 == heap.size() - 1) {
                if(heap.get(ind) < heap.get(ind * 2)) {
                    int tmp = heap.get(ind);
                    heap.set(ind, heap.get(ind * 2));
                    heap.set(ind * 2, tmp);
                }
                break;
            } else {
                int maxInd = heap.get(ind * 2) > heap.get(ind * 2 + 1) ? ind * 2 : ind * 2 + 1;
                if (heap.get(maxInd) > heap.get(ind)) {
                    int tmp = heap.get(ind);
                    heap.set(ind, heap.get(maxInd));
                    heap.set(maxInd, tmp);

                    ind = maxInd;
                } else
                    break;
            }
        }

        return rs;
    }
}
