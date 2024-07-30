import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] ratValues = new int[2];
		int[][] rats = new int[2][n];
		for(int i = 0; i < 2; i++) {
			String[] comp = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				rats[i][j] = Integer.parseInt(comp[j]);
			}
			Arrays.sort(rats[i]);
			
			int maxCnt = 0, ratValue = 0;
			int left = 0, right = 0;
			while(right < n) {
				if(rats[i][right] - rats[i][left] <= 4) {
					if(maxCnt < right - left + 1) {
						maxCnt = right - left + 1;
						ratValue = (rats[i][right] + rats[i][left]) / 2;
					}
					
					right++;
				} 
				else {
					left++;
				}
			}
			if(maxCnt < right - left) {
				ratValue = (rats[i][right] - 1 + rats[i][left]) / 2;
			}
			
			ratValues[i] = ratValue;
		}
		
		System.out.println(ratValues[0] + " " + ratValues[1]);
		System.out.println(ratValues[0] - ratValues[1] > 0 ? "good" : "bad");
		
		
		// 1 2 3 4 5
		
		
	}
}