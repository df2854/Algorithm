import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point> {
		int y, x, w;

		public Point(int y, int x, int w) {
			super();
			this.y = y;
			this.x = x;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			return this.w - o.w;
		}
	}
	static int n, result;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int idx = 1;
		while (true) {
			n = Integer.parseInt(br.readLine());
			
			if (n == 0) break;
			
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[n][n];
			result = 0;
			PriorityQueue<Point> pq = new PriorityQueue<>();
			pq.offer(new Point(0, 0, map[0][0]));
			visited[0][0] = true;
			
			while (!pq.isEmpty()) {
				Point cur = pq.poll();
				int cy = cur.y;
				int cx = cur.x;
				
				if (cy == n-1 && cx == n-1) {
					result = cur.w;
					break;
				}
				
				for (int[] d : dir) {
					int ny = cy + d[0];
					int nx = cx + d[1];
					
					if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx]) continue;
					
					visited[ny][nx] = true;
					pq.offer(new Point(ny, nx, cur.w + map[ny][nx]));
				}
			}
			
			sb.append("Problem ").append(idx).append(": ").append(result).append("\n");
			idx++;
		}
		
		System.out.println(sb);
	}
}
