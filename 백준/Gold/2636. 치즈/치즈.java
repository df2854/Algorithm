import java.io.*;
import java.util.*;

public class Main {
	static int n, m, time, count;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> que;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		time = 0;
		while(checked()) {
			count = 0;
			
			count();
			
			visited = new boolean[n][m];
			que = new ArrayDeque<>();
			meltChecked();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == -1) {
						map[i][j] = 0;
					}
				}
			}
			
			time++;
		}
		
		System.out.println(time);
		System.out.println(count);
 	}
	private static void count() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					count++;
				}
			}
		}
	}
	
	private static void meltChecked() {
		que.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int cy = cur[0];
			int cx = cur[1];
			for (int[] d : dir) {
				int ny = cy + d[0];
				int nx = cx + d[1];
				
				if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
					if (!visited[ny][nx] && map[ny][nx] == 0) {
						visited[ny][nx] = true;
						que.offer(new int[] {ny, nx});
					}
					if (map[ny][nx] == 1) map[ny][nx] = -1;
				}
			}
		}
	}
	
	private static boolean checked() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) return true;
			}
		}
		return false;
	}
}