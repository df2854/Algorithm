import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int y, x, dist, broke;

		public Point(int y, int x, int dist, int broke) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
			this.broke = broke;
		}
	}
	static int n, m, result;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		result = -1;
		visited = new boolean[n][m][2];
		int brokeCnt = 0;
		
		Queue<Point> que = new ArrayDeque<>();
		que.offer(new Point(0, 0, 1, 0));
		visited[0][0][0] = true;
		
		while (!que.isEmpty()) {
			Point cur = que.poll();
			int cy = cur.y;
			int cx = cur.x;
			
			if (cy == n - 1 && cx == m - 1) {
				result = cur.dist;
				break;
			}
			
			for (int[] d : dir) {
				int ny = cy + d[0];
				int nx = cx + d[1];
				
				if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
				
				if (map[ny][nx] == 0 && !visited[ny][nx][cur.broke]) {
					visited[ny][nx][cur.broke] = true;
					que.offer(new Point(ny, nx, cur.dist + 1, cur.broke));
				}
				
				if (map[ny][nx] == 1 && cur.broke == 0 && !visited[ny][nx][1]) {
					visited[ny][nx][1] = true;
					que.offer(new Point(ny, nx, cur.dist+1, 1));
				}
			}

		}
		
		System.out.println(result);
	}
}