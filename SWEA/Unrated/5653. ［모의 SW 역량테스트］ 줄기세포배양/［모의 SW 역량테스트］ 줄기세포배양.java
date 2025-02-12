import java.io.*;
import java.util.*;

public class Solution {
	static final int DEAD=0, ACTIVE=1, INACTIVE=2;
	static class Point {
		int y;
		int x;
		int time;
		int power;
		int state; // 0 : dead, 1 : active, 2 : inactive
		
		Point (int y, int x, int time, int power) {
			this.y = y;
			this.x = x;
			this.time = time;
			this.power = power;
			this.state = INACTIVE;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		PriorityQueue<Point> que;
		List<Point> list;
		
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();
			que = new PriorityQueue<>((o1, o2) -> o2.power - o1.power );
			boolean[][] visited = new boolean[n+2*k][m+2*k];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num != 0) {
						list.add(new Point(i + k, j + k, num, num));
						visited[i + k][j + k] = true;
					}
				}
			}
			
			for (int time = 1; time <= k; time++) {
				while (!que.isEmpty()) {
					Point p = que.poll();
					int y = p.y;
					int x = p.x;
					
					if (!visited[y][x]) {
						visited[y][x] = true;
						list.add(p);
					}
				}
				
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).state == DEAD) continue;
					else if (list.get(i).state == INACTIVE && list.get(i).time == time) {
						list.get(i).state = ACTIVE;
						list.get(i).time = time + list.get(i).power;
						
						for (int dir = 0; dir < 4; dir++) {
							int ny = list.get(i).y + dy[dir];
							int nx = list.get(i).x + dx[dir];
							
							que.add(new Point(ny, nx, time + 1 + list.get(i).power, list.get(i).power));
						}
					} else if (list.get(i).state == ACTIVE && list.get(i).time == time) {
						list.get(i).state = DEAD;
						list.get(i).time = 0;
						list.get(i).power = 0;
					}
				}
			}
			int ans = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).state == ACTIVE || list.get(i).state == INACTIVE) {
					ans++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
