import java.io.*;
import java.util.*;

public class Main {
	static int m, n, result;
	static int[][] map;
	static Queue<int[]> que;
	static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		que = new ArrayDeque<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					result++;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(result);
	}
	private static void bfs(int y, int x) {
		map[y][x] = -1;
		que.offer(new int[] {y, x});
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int cy = cur[0];
			int cx = cur[1];
			
			for (int[] d : dir) {
				int ny = cy + d[0];
				int nx = cx + d[1];
				
				if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
				
				if (map[ny][nx] == 1) {
					map[ny][nx] = -1;
					que.offer(new int[] {ny, nx});
				}
			}
		}
	}
}
