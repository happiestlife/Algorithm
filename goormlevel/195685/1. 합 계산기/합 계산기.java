import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int result = 0;
		while(t-- > 0) {
			String[] comps = br.readLine().split(" ");
			int x = Integer.parseInt(comps[0]);
			int y = Integer.parseInt(comps[2]);
			char oper = comps[1].charAt(0);
			
			switch(oper) {
				case '+':
					result += x + y;
					break;
				case '-':
					result += x - y;	
					break;
				case '/':
					result += x / y;
					break;
				case '*':
					result += x * y;
					break;
			}
		}
		System.out.println(result);
	}
}