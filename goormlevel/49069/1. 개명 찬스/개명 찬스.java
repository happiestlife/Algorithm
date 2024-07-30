import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int removeIdx = -1;
		for(int i = 1; i < s.length(); i++) {
			char prevC = s.charAt(i-1);
			char curC = s.charAt(i);
			
			// System.out.println(prevC + ", " + curC);
			// System.out.println((int)prevC + ", " + (int)curC);
			if(prevC > curC) {
				removeIdx = i - 1;
				break;
			}
		}
		if(removeIdx == -1) removeIdx = s.length() - 1;
		System.out.println(s.substring(0, removeIdx) + s.substring(removeIdx + 1));
	}
}