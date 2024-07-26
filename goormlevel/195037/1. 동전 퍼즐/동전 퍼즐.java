import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		char[][] originMap = getMap(Integer.parseInt(size[0]), Integer.parseInt(size[1]), br);
		size = br.readLine().split(" ");
		char[][] curMap = getMap(Integer.parseInt(size[0]), Integer.parseInt(size[1]), br);
		
		// origin의 동전 위치 파악
		List<Point> coinPoints = new ArrayList<>();
		for(int i = 0; i < originMap.length; i++) {
			for(int j = 0;j < originMap[i].length; j++) {
				if(originMap[i][j] == 'O') {
					coinPoints.add(new Point(i, j));
				}
			}
		}
		
		// 바꿔야하는 map에서 코인이 있는 자리를 기점으로 origin map을 만들기 위해서는 몇 개의 코인을 옮겨야 하는지 확인
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < curMap.length; i++) {
			for(int j = 0; j < curMap[i].length; j++) {
				if(curMap[i][j] == '.') continue;
				// System.out.println("coin Point : " + i + ", " + j);
				
				// 코인 있는 자리에서 최소 옮겨야 하는 코인 개수 구하기
				for(int k = 0; k < coinPoints.size(); k++) {
					Point curPoint = coinPoints.get(k);
					// System.out.println(" start coin point : " + curPoint.x + " , " + curPoint.y);
			
					int curMoveCnt = 0;
					for(int l = 0; l < coinPoints.size(); l++) {
						if(k == l) continue;
						Point anotherPoint = coinPoints.get(l);
						
						int moveX = i + (anotherPoint.x - curPoint.x);
						int moveY = j + (anotherPoint.y - curPoint.y);
						
						if((moveX < 0 || moveX >= curMap.length) ||
							(moveY < 0 || moveY >= curMap[0].length) ||
							(curMap[moveX][moveY] == '.')) {
							curMoveCnt++;
						}
					}
					// System.out.println(" start coin point cnt: " + curMoveCnt);
					
					
					min = Math.min(min, curMoveCnt);
				}
			}
		}
		
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
	
	private static char[][] getMap(int height, int width, BufferedReader br) throws Exception{
		char[][] map = new char[height][width];
		for(int i = 0; i < map.length; i++){
			String s = br.readLine();
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		return map;
	}
	
	private static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		} 
	}
}