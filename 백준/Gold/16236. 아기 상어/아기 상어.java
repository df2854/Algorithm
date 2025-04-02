import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point> {
		int y, x, dist;

		public Point(int y, int x, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			if (this.dist != o.dist) {
				return this.dist - o.dist;
			}
			if (this.y != o.y) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException {
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
		
		int eatCnt = 0;
		int size = 2;
		int move = 0;
		
		while (true) {
			PriorityQueue<Point> pq = new PriorityQueue<>();
			visited = new boolean[n][n];
			pq.offer(new Point(cur.y, cur.x, 0));
			visited[cur.y][cur.x] = true;
			
			boolean eat = false;
			
			while (!pq.isEmpty()) {
				cur = pq.poll();
				int cy = cur.y;
				int cx = cur.x;
				
				if (map[cy][cx] != 0 && map[cy][cx] < size) {
					map[cy][cx] = 0;
					eatCnt++;
					eat = true;
					move += cur.dist;
					break;
				}
				
				for (int[] d : dir) {
					int ny = cy + d[0];
					int nx = cx + d[1];
					
					if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] || map[ny][nx] > size) continue;
					
					visited[ny][nx] = true;
					pq.offer(new Point(ny, nx, cur.dist + 1));
				}
			}
			
			if (!eat) {
				break;
			}
			
			if (eatCnt == size) {
				eatCnt = 0;
				size++;
			}
		}
		
		System.out.println(move);
	}
}
