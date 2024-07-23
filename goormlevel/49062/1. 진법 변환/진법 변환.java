import java.io.*;
import java.util.*;
class Main {
	
	private static final char[] charNum = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	private static final int[] num = new int[charNum.length];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		String t = stk.nextToken();
	
		for(int i = 0; i < num.length; i++) num[i] = i;
		
		int result = -1;
		for(int i = 2; i <= 16; i++) {
			int num = 0;
			for(int j = t.length() - 1; j >= 0; j--) {
				int curNum = getNum(t.charAt(j));
				if(curNum >= i) break;

				num += curNum * Math.pow(i, t.length() - 1 - j);
			}
			
			if(num == n) {
				result = i;
				break;
			}
		}
					
		System.out.println(result);
	}
	
	private final static int getNum(char c) {
		int idx = 0;
		for(int i = 0; i < charNum.length; i++) {
			if(c == charNum[i]) {
				idx = i;
				break;
			}
		}
		
		return num[idx];
	}
}