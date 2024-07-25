import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int max = 0, continueSum = 0, prevScore = 0;
		String[] comps = br.readLine().split(" ");
		for(int i = 0; i < comps.length; i++) {
			int score = Integer.parseInt(comps[i]);
			
			// 2번 방식
			// 시작하는 문제 or 연속적으로 점수가 1 증가한 문제
			if(continueSum == 0 || prevScore + 1 == score) {
				continueSum += score;
				prevScore = score;
			}
			else {
				max = Math.max(max, continueSum);
				continueSum = score;
				prevScore = score;
			}
			
			// 1번 방식
			max = Math.max(max, score);
		}
		max = Math.max(max, continueSum);
		
		
		System.out.println(max);
	}
}