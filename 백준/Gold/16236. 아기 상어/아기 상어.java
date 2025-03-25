import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static PriorityQueue<Point> pq;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		Point cur = null;
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					cur = new Point(i, j, 0);
					map[i][j] = 0;
				}
			}
		}
		
		int eatCount = 0;
		int size = 2;
		int move = 0;
		
		while (true) {
			pq = new PriorityQueue<>(new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					int cmp = o1.dist - o2.dist;
					if (cmp == 0) {
						int cmp2 = o1.y - o2.y;
						if (cmp2 == 0) return o1.x - o2.x;
						return cmp2;
					}
					return cmp;
				}
			});
			visited = new boolean[n][n];
			
			pq.offer(new Point(cur.y, cur.x, 0));
			visited[cur.y][cur.x] = true;
			
			boolean eat = false;
			
			while(!pq.isEmpty()) {
				cur = pq.poll();
				
				if (map[cur.y][cur.x] != 0 && map[cur.y][cur.x] < size) {
					map[cur.y][cur.x] = 0;
					eatCount++;
					eat = true;
					move += cur.dist;
					break;
				}
				
				for (int[] d : dir) {
					int ny = cur.y + d[0];
					int nx = cur.x + d[1];
					
					if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx] || map[ny][nx] > size) continue;
					
					pq.offer(new Point(ny, nx, cur.dist+1));
					visited[ny][nx] = true;
				}
			}
			
			if (!eat) break;
			
			if (eatCount == size) {
				eatCount = 0;
				size++;
			}
		}
		
		System.out.println(move);
	}
	
}
class Point {
	int y, x, dist;
	
	Point(int y, int x, int dist) {
		this.y = y;
		this.x = x;
		this.dist = dist;
	}
}