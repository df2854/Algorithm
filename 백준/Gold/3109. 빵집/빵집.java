import java.io.*;
import java.util.*;

public class Main {
	static int r, c, result;
	static char[][] map;
	static boolean flag;
	static boolean[][] visited;
	static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		result = 0;
		
		for (int i = 0; i < r; i++) {
			flag = false;
			dfs(i, 0);
		}
		
		System.out.println(result);
	}
	private static void dfs(int row, int col) {
		if (col == c-1) {
			result++;
			flag = true;
			visited[row][col] = true;
			return;
		}
		
		for (int d = 0; d < 3; d++) {
			int nr = row + dir[d][0];
			int nc = col + dir[d][1];
			
			if(nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == '.' && !visited[nr][nc]) {
				dfs(nr, nc);
				visited[row][col] = true;
				if (flag) return;
			}
		}
	}
}