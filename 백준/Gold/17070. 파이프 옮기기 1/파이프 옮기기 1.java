import java.io.*;
import java.util.*;

public class Main {
	static int n, result;
	static int[][] map;
	static int[][] dir = {{0, 1}, {1, 0}, {1, 1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		
		dfs(0, 1, 0);
		
		System.out.println(result);
 	}
	private static void dfs(int y, int x, int direction) {
		if (y == n-1 && x == n-1) {
			result++;
			return;
		}
		
		if (direction == 0) {
			int ny = y;
			int nx = x + 1;
			if (ny < n && nx < n && map[ny][nx] == 0) {
				dfs(ny, nx, 0);
			}
		} else if (direction == 1) {
			int ny = y + 1;
			int nx = x;
			if (ny < n && nx < n && map[ny][nx] == 0) {
				dfs(ny, nx, 1);
			}
		} else if (direction == 2) {
			for (int d = 0; d < 2; d ++) {
				int ny = y + dir[d][0];
				int nx = x + dir[d][1];
				if (ny < n && nx < n && map[ny][nx] == 0) {
					dfs(ny, nx, d);
				}
			}
		}
		
		if (isCheck(y, x)) {
			dfs(y+1, x+1, 2);
		}
	}
	private static boolean isCheck(int y, int x) {
		for (int[] d : dir) {
			int ny = y + d[0];
			int nx = x + d[1];
			
			if (ny >= n || nx >= n || map[ny][nx] != 0) return false;
		}
		return true;
	}

}