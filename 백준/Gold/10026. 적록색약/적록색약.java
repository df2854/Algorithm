import java.io.*;
import java.util.*;

public class Main {
	static int n, rgCnt, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		rgCnt = 0;
		cnt = 0;
		
		
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j, false);
					cnt++; 
				}
			}
		}
		
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j, true);
					rgCnt++; 
				}
			}
		}
		
		System.out.println(cnt + " " + rgCnt);
	}
	private static void bfs(int y, int x, boolean rg) {
		Queue<int[]> que = new ArrayDeque<>();
		char color = map[y][x];
		
		que.offer(new int[] {y, x});
		visited[y][x] = true;
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int cy = cur[0], cx = cur[1];
			
			for (int[] d : dir) {
				int ny = cy + d[0];
				int nx = cx + d[1];
				
				if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
				if (visited[ny][nx]) continue;
				
				if (rg) {
					if ((color == 'R' || color == 'G') && (map[ny][nx] == 'R' || map[ny][nx] == 'G')) {
						que.offer(new int[] {ny, nx});
						visited[ny][nx] = true;
					} else if (map[ny][nx] == color) {
						que.offer(new int[] {ny, nx});
						visited[ny][nx] = true;
					}
				} else {
					if (map[ny][nx] == color) {
						que.offer(new int[] {ny, nx});
						visited[ny][nx] = true;
					}
				}
			}
		}
	}
}
