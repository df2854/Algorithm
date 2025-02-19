import java.util.*;
import java.io.*;

class Solution {
	static int tc, n;
	static int[][] arr;
	static int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			
			dfs(1, 0, 0, 0);
			
			System.out.println("#" + t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	private static void dfs(int num, int y, int x, int dir) {
		if (num == n * n + 1) {
			return;
		}
		
		arr[y][x] = num;
		
		int ny = y + d[dir % 4][0];
		int nx = x + d[dir % 4][1];
		
		if (ny < 0 || ny >= n || nx < 0 || nx >= n || arr[ny][nx] != 0) {
			dir++;
			ny = y + d[dir % 4][0];
			nx = x + d[dir % 4][1];
			dfs(num+1, ny, nx, dir);
		} else {
			dfs(num+1, ny, nx, dir);
		}
	}
}
