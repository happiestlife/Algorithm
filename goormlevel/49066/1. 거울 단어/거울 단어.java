import java.io.*;
import java.lang.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		final char[] originChar = {'b', 'i', 'l', 'm', 'n', 'o', 'p', 's', 'u', 'v', 'w', 'x'};
		final char[] mirrorChar = {'d', 'i', 'l', 'm', 'n', 'o', 'q', 'z', 'u', 'v', 'w', 'x'};
		Map<Character, Character> mirror = new HashMap<>();
		for(int i = 0; i < originChar.length; i++) {
			mirror.put(originChar[i], mirrorChar[i]);
			mirror.put(mirrorChar[i], originChar[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		while(t-- > 0) {
			String str = br.readLine();
			int left = 0, right = str.length() - 1;
			boolean isMirror = true;
			while(left <= right) {
				char leftC = str.charAt(left++);
				char rightC = str.charAt(right--);
				if(!mirror.containsKey(leftC) || mirror.get(leftC) != rightC) {
					isMirror = false;
					break;
				}
			}
			
			if(isMirror) sb.append("Mirror\n");
			else sb.append("Normal\n");
		}
		System.out.println(sb);
	}
}