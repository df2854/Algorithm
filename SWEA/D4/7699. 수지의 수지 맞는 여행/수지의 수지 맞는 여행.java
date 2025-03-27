import java.io.*;
import java.util.*;

class Solution {
	static int tc, r, c, result;
	static char[][] map;
	static List<Character> list;
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
			
			list = new ArrayList<>();
			list.add(map[0][0]);
			
			result = -1;
			
			dfs(0, 0, 1);
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int i, int j, int depth) {
		result = Math.max(result, depth);
		for (int[] d : dir) {
			int ny = i + d[0];
			int nx = j + d[1];
			
			if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
			if (list.contains(map[ny][nx])) continue;
			
			list.add(map[ny][nx]);
			dfs(ny, nx, depth+1);
			list.remove(list.size() - 1);
		}
	}
}