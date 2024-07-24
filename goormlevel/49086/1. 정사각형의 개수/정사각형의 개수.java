import java.io.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		BigInteger sum = new BigInteger("0");
		for(int i = 1; i <= n; i++) {
			sum = sum.add(new BigInteger(String.valueOf((long)i * i)));
		}
		
		System.out.println(sum);
	}
}