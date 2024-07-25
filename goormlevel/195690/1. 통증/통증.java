import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = n / 14;
		n %= 14;
		cnt += n / 7;
		n %= 7;
		cnt += n;
		
		System.out.println(cnt);
	}
}