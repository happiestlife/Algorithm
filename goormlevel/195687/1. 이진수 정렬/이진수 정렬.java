import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] comp = br.readLine().split(" ");
		int n = Integer.parseInt(comp[0]);
		int k = Integer.parseInt(comp[1]);
		
		List<Integer> arr = new ArrayList<>();
		comp = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(comp[i]));
		}
		
		Collections.sort(arr, (n1, n2) -> {
			int n1OneCnt = getOneCnt(n1);
			int n2OneCnt = getOneCnt(n2);
			
			if(n1OneCnt == n2OneCnt) return n2 - n1;
			else return n2OneCnt - n1OneCnt;
		});
		
		System.out.println(arr.get(k - 1));
	}
	
	private static int getOneCnt(int n) {
		int cnt = 0;
		while(n > 1) {
			if(n % 2 == 1) cnt++;
			n /= 2;
		}
		
		return cnt;
	}
}