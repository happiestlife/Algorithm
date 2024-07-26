import java.io.*;
import java.lang.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		List<String> list = new ArrayList<>();
		while(n-- > 0) {
			list.add(br.readLine());
		}
		
		Collections.sort(list, (s1, s2) -> {
			if(s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			else {
				return s1.length() - s2.length();
			}
		});
		System.out.println(list.get(k - 1));
	}
}