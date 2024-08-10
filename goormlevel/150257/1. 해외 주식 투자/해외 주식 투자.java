import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<JuSik> values = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String[] comp = br.readLine().split(" ");
			double cnt = Double.parseDouble(comp[0]);
			double oneValue = Integer.parseInt(comp[1]);
			
			//System.out.println(value);
			
			values.add(new JuSik(i + 1,  Math.floor(cnt * oneValue * 10)));
		}
		
		Collections.sort(values, (v1, v2) -> {
			if(v1.value == v2.value) {
				return v1.idx - v2.idx;
			} else {
				return Double.compare(v2.value, v1.value);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(JuSik jusik : values) {
			sb.append(jusik.idx + " ");
		}
		System.out.println(sb.toString().trim());
	}
	
	static class JuSik {
		int idx;
		double value;
		
		public JuSik(int idx, double value) {
			this.idx = idx;
			this.value = value;
		}
	}
}