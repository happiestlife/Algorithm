import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] comp = br.readLine().split(" ");
		int maxIdx = 0;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(comp[i]);
			if(arr[i] > arr[maxIdx]) maxIdx = i;
		}
		
		int leftSum  = getSum(arr, maxIdx, -1);
		int rightSum = getSum(arr, maxIdx, +1);
		
		int result = leftSum == 0 || rightSum == 0 ? 0 : leftSum + rightSum - arr[maxIdx];
		System.out.println(result);
	}
	
	private static int getSum(int[] arr, int idx, int move) {
		int sum = 0;
		int prev = arr[idx];
		while(0 <= idx && idx < arr.length) {
			int cur = arr[idx];
			if(prev < cur) return 0;
			
			sum += cur;
			prev = cur;
			idx += move;
		}
		
		return sum;
	}
}