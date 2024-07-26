import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] comp = br.readLine().split(" ");
		int money = Integer.parseInt(comp[0]);
		int c = Integer.parseInt(comp[1]);
		
		Queue<Integer> reservedPay = new LinkedList<>();
		while(c-- > 0) {
			comp = br.readLine().split(" ");
			char cmd = comp[0].charAt(0);
			int m = Integer.parseInt(comp[1]);
			
			switch(cmd) {
				case 'd':
					money += m;
					if(money > 0) {
						while(!reservedPay.isEmpty() && 
									reservedPay.peek() <= money) {
							money -= reservedPay.poll();
						}
					}
					break;
				case 'p':
					if(m <= money) money -= m;
					break;
				case 'r':
					if(m > money || !reservedPay.isEmpty()) reservedPay.add(m);
					else money -= m;
					break;
			}
		}
		System.out.println(money);
	}
}