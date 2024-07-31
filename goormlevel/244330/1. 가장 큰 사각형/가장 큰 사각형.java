import java.io.*;
import java.lang.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int max = 0;
		while(t-- > 0) {
			String[] comps = br.readLine().split(" ");
			int x = Integer.parseInt(comps[0]);
			int y = Integer.parseInt(comps[1]);
			max = Math.max(max, x * y);
		}
		System.out.println(max);
	}
}