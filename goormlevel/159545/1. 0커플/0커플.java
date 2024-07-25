import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int i = 0;
		Set<Integer> set = new HashSet<>();
		for(String comp: br.readLine().split(" ")){
			int score = Integer.parseInt(comp);
			if(set.contains(score)) set.remove(score);
			elseset.add(score);
		}
		
		int sum = 0;
		for(int score : set) {
			sum += score;
		}
		System.out.println(sum);
	}
}