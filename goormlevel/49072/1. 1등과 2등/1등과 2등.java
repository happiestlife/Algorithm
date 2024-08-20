import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();
        
        boolean found12 = false;
        boolean found21 = false;

        int n = input.length();
        int i = 0;
        
        // Scan for "12" and "21" without overlap
        while (i < n - 1) {
            if (input.startsWith("12", i)) {
                found12 = true;
                i += 2;  // Skip past "12"
                // After finding "12", search for "21"
                while (i < n - 1) {
                    if (input.startsWith("21", i)) {
                        found21 = true;
                        break;
                    }
                    i++;
                }
                if (found21) break;  // Stop if both are found
            } else if (input.startsWith("21", i)) {
                found21 = true;
                i += 2;  // Skip past "21"
                // After finding "21", search for "12"
                while (i < n - 1) {
                    if (input.startsWith("12", i)) {
                        found12 = true;
                        break;
                    }
                    i++;
                }
                if (found12) break;  // Stop if both are found
            } else {
                i++;
            }
        }

        // Final decision
        if (found12 && found21) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
