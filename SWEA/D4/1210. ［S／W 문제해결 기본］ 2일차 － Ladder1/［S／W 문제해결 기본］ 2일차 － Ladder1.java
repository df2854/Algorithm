import java.util.*;
import java.io.*;

class Solution {
	static int[][] map;
	static int endY, endX, result;
	static int[][] d = {{0, -1}, {0, 1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						endY = i;
						endX = j;
					}
				}
			}
			
			dfs(endY, endX);
			
			System.out.println("#" + tc + " " + result);
		}
	}
	private static void dfs(int y, int x) {
		if (y == 0) {
			result = x;
			return;
		}
		
		if (x > 0 && map[y][x - 1] == 1) {
			while (x > 0 && map[y][x-1] == 1) {
				x--;
			}
			dfs(y - 1, x);
		} else if (x < 99 && map[y][x + 1] == 1) {
			while (x < 99 && map[y][x+1] == 1) {
				x++;
			}
			dfs(y - 1, x);
		} else dfs(y - 1, x);
	}
}