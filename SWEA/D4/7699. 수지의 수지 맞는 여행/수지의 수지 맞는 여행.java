import java.io.*;
import java.util.*;

class Solution {
	static int tc, r, c, result;
	static char[][] map;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			map = new char[r][c];
			for (int i = 0; i < r; i++) {
				String input = br.readLine();
				for (int j = 0; j < c; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			
			result = -1;
			
			dfs(0, 0, 1, 1 << (map[0][0] - 'A'));
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int i, int j, int depth, int bit) {
		result = Math.max(result, depth);
		for (int[] d : dir) {
			int ny = i + d[0];
			int nx = j + d[1];
			
			if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
			int c = map[ny][nx] - 'A';
			if ((bit | (1 << c)) == bit) continue;
		
			dfs(ny, nx, depth+1, bit | (1 << c));
		}
	}
}