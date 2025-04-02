import java.io.*;
import java.util.*;

class Solution {
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
	static int tc, n;
	static int[][] map, dist;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			visited = new boolean[n][n];
			
			PriorityQueue<Point> pq = new PriorityQueue<>();
			dist[0][0] = 0;
			visited[0][0] = true;
			pq.offer(new Point(0, 0, dist[0][0]));
			
			while(!pq.isEmpty()) {
				Point cur = pq.poll();
				int cy = cur.y;
				int cx = cur.x;
				
				if (cy == n - 1 && cx == n - 1) break;
				
				for (int[] d : dir) {
					int ny = cy + d[0];
					int nx = cx + d[1];
					
					if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
					if (visited[ny][nx]) continue;
					
					if (dist[ny][nx] > dist[cy][cx] + map[ny][nx]) {
						dist[ny][nx] = dist[cy][cx] + map[ny][nx];
						visited[ny][nx] = true;
						pq.offer(new Point(ny, nx, dist[ny][nx]));
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(dist[n-1][n-1]).append("\n");
		}
		System.out.println(sb);
	}
}
