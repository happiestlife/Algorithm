import java.io.*;
import java.util.*;
import java.util.stream.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		List<String[]> subStrs = new ArrayList<>();
		Set<String> compSet = new HashSet<String>();
		for(int i = 0; i < s.length() - 2; i++) {
			for(int j = i + 1; j < s.length() - 1; j++) {
				for(int k = j + 1; k < s.length(); k++) {
					String sub1 = s.substring(0, i + 1);
					String sub2 = s.substring(i + 1, j + 1);
					String sub3 = s.substring(j + 1);
					
					compSet.add(sub1);
					compSet.add(sub2);
					compSet.add(sub3);
					
					subStrs.add(new String[]{sub1, sub2, sub3});
				}
			}
		}
		

		List<String> compList = compSet.stream().sorted().collect(Collectors.toList());
		Map<String, Integer> scoreByComp = new HashMap<>();
		for(int i = 0; i < compList.size(); i++) {
			scoreByComp.put(compList.get(i), i + 1);
		}
		
		int max = 0;
		for(String[] subStr : subStrs) {
			int curSum = 0;
			for(String subStrComp : subStr) curSum += scoreByComp.get(subStrComp);
			
			max = Math.max(max, curSum);
		}
		
		System.out.println(max);
	}
}