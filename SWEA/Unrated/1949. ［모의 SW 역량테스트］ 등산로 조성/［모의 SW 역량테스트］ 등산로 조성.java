import java.io.*;
import java.util.*;

class Solution {
	static int tc, n, k, max, result;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			max = 0;
			
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					max = Math.max(max, map[i][j]);
				}
			}
			
			result = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == max) {
						visited = new boolean[n][n];
						visited[i][j] = true;
						dfs(i, j, 0, 1);
						visited[i][j] = false;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int y, int x, int con, int len) {
		result = Math.max(result, len);
		
		for (int[] d : dir) {
			int ny = y + d[0];
			int nx = x + d[1];
			
			if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
			
			if (map[ny][nx] < map[y][x] && !visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(ny, nx, con, len + 1);
				visited[ny][nx] = false;
			}
			
			if (con == 0 && map[ny][nx] >= map[y][x] && map[ny][nx] - k < map[y][x] && !visited[ny][nx]) {
				int tmp = map[ny][nx];
				map[ny][nx] = map[y][x] - 1; 
				visited[ny][nx] = true;
				dfs(ny, nx, 1, len + 1);
				visited[ny][nx] = false;
				map[ny][nx] = tmp;
			}
		}
	}
}