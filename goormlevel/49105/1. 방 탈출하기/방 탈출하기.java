import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Set<Integer> nums = new HashSet<>();
		for(String num : br.readLine().split(" ")) {
			nums.add(Integer.parseInt(num));
		}
		
		int m = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(String num : br.readLine().split(" ")) {
			if(nums.contains(Integer.parseInt(num))) {
				sb.append("1\n");
			}
			else {
				sb.append("0\n");
			}
		}
		System.out.println(sb.toString().trim());
	}
}