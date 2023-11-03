import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] comp = br.readLine().split(" ");
                String name = comp[0];
                String type = comp[1];

                if(map.containsKey(type)){
                    List<String> clothNames = map.get(type);
                    clothNames.add(name);
                    map.put(type, clothNames);
                }
                else{
                    List<String> clothNames = new ArrayList<>();
                    clothNames.add(name);
                    map.put(type, clothNames);
                }
            }

            long sum = 1;
            for (String type : map.keySet()) {
                sum *= (map.get(type).size() + 1);
            }
            sum--;

            sb.append(sum + "\n");
        }

        System.out.println(sb);

        br.close();
    }
}
