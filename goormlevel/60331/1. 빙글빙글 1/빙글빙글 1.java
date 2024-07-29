import java.io.*;
import java.util.*;
import java.lang.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] isSanil = new boolean[n][n];
		
		final int[] dx = {0, 1, 0, -1};
		final int[] dy = {1, 0, -1, 0};
		
		int len = n, direct = 0;
		int curX = 0, curY = -1;
		for(int i = 0; i < n; i++) {
			// System.out.println(i + " : " + len + ", " + curX + " : " + curY);
			for(int j = 0; j < len; j++) {
				curX += dx[direct];
				curY += dy[direct];
				// System.out.println(" >> " + curX + " : " + curY);
				isSanil[curX][curY] = true;
			}
			
			
			if(i == 0) len--;
			else if(i % 2 == 0) len -= 2;
			direct = (direct + 1) % dx.length;
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(isSanil[i][j]) sb.append("# ");
				else sb.append("  ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}