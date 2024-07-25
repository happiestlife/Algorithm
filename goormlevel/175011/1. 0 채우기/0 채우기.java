import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		int[] xSum = new int[n];
		int[] ySum = new int[n];
		
		int zeroX = 0, zeroY = 0;
		for(int i = 0; i < n; i++) {
			String[] comp = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				int num = Integer.parseInt(comp[j]);
				xSum[i] += num;
				ySum[j] += num;
				
				if(num == 0) {
					zeroX = i;
					zeroY = j;
				}
			}
		}
		System.out.println(xSum[zeroX] + ySum[zeroY]);
	}
}