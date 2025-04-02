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
	static int n, m, result;
	static int[][] map;
	static boolean visited[][];
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		visited = new boolean[n][m];
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		
		result = 0;
		
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			int cy = cur.y;
			int cx = cur.x;
			
			if (cy == n-1 && cx == m-1) {
				result = cur.w;
				break;
			}
			
			for (int[] d : dir) {
				int ny = cy + d[0];
				int nx = cx + d[1];
				
				if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx]) continue;
				
				visited[ny][nx] = true;
				pq.offer(new Point(ny, nx, cur.w + map[ny][nx]));
			}
		}
		
		System.out.println(result);
	}
}
