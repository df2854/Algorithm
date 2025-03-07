import java.io.*;
import java.util.*;

public class Main {
	static int r, c, cnt;
	static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
	static char[][] map;
	static boolean[][] visited;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for (int i = 0; i < r; i++) {
			String input = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		cnt = 0;
		
		for (int i = 0; i < r; i++) {
			flag = false;
			dfs(i ,0);
		}
		
		System.out.println(cnt);
	}
	private static void dfs(int y, int x) {
		if (x == c - 1) {
			cnt++;
			visited[y][x] = true;
			flag = true;
			return;
		}
		
		for (int[] d : dir) {
			int ny = y + d[0];
			int nx = x + d[1];
			
			if (ny >= 0 && ny < r && nx >= 0 && nx < c && map[ny][nx] == '.' && !visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(ny, nx);
				if (flag) return;
			}
		}
	}
}
