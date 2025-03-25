import java.io.*;
import java.util.*;

public class Main {
	static int n, m, time;
	static int[][] map;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] visited;
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
			Queue<int[]> que = new ArrayDeque<>();
			visited = new boolean[n][m];
			
			que.offer(new int[] {0, 0});
			visited[0][0] = true;
			
			while(!que.isEmpty()) {
				int[] cur = que.poll();
				int cy = cur[0];
				int cx = cur[1];
				
				for (int[] d : dir) {
					int ny = cy + d[0];
					int nx = cx + d[1];
					
					if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
					
					if (map[ny][nx] == 0 && !visited[ny][nx]) {
						que.offer(new int[] {ny, nx});
						visited[ny][nx] = true;
					} else if (map[ny][nx] == 1) {
						if (visited[ny][nx]) map[ny][nx] = -1;
						else visited[ny][nx] = true;
					}
				}
			}
			
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
	}
	private static boolean checked() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					return true;
				}
			}
		}
		return false;
	}
}
