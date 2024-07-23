import java.io.*;
import java.util.*;

class Main {
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int d = Integer.parseInt(stk.nextToken());
		
		int[] ants = getAnts(n, br.readLine());
		
		int minRemovedCnt = ants.length;
		int left = 0, right = 0;
		while(right < ants.length) {
			int dist = ants[right] - ants[left];
			if(dist <= d) {
				minRemovedCnt = Math.min(minRemovedCnt, ants.length - (right - left + 1));
				right++;
			}
			else {
				if(left == right) {
					right++;
				}
				else {
					left++;
				}
			}
			
		}
		
		System.out.println(minRemovedCnt);
	}
	
	private static int[] getAnts(int size, String antsStr) {
		int[] ants = new int[size];
		StringTokenizer stk = new StringTokenizer(antsStr);
		for(int i = 0; i < ants.length; i++) {
			ants[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(ants);
		
		return ants;
	}
}