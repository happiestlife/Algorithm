import java.io.*;
import java.util.*;
import java.lang.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		System.out.println(isTrue(s) ? "Yes" : "No");
	}
	
	private static boolean isTrue(String s) {
		final String[] validGrades = { "12", "21" };
		
		List<Integer>[] startPoints = new List[validGrades.length];
		for(int i = 0; i < startPoints.length; i++) {
			startPoints[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < validGrades.length; i++) {
			String validGrade = validGrades[i];
			
		 	int startPoint = -1;
			while(true) {
				startPoint = s.indexOf(validGrade, startPoint);
				if(startPoint == -1) break;
				
				startPoints[i].add(startPoint++);
			}
		}
		
		for(List<Integer> startPoint : startPoints) if(startPoint.isEmpty()) return false;
		List<Integer> startPoint12 = startPoints[0];
		List<Integer> startPoint21 = startPoints[1];
		int firstIdx12 = startPoint12.get(0), lastIdx12 = startPoint12.get(startPoint12.size() - 1);
		int firstIdx21 = startPoint21.get(0), lastIdx21 = startPoint21.get(startPoint21.size() - 1);
		
		if(firstIdx12 + 2 <= lastIdx21 || firstIdx21 + 2 <= lastIdx12) return true;
		else return false;
	}
}