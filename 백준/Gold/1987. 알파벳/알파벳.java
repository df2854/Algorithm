import java.io.*;
import java.util.*;

public class Main {
	static int r, c, result;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static char[][] map;
	static List<Character> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
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
		result = 0;
		list.add(map[0][0]);
		dfs(0, 0, 1);
		
		System.out.println(result);
	}
	private static void dfs(int y, int x, int cnt) {
		result = Math.max(result, cnt);
		for (int[] d : dir) {
			int ny = y + d[0];
			int nx = x + d[1];
			
			if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
			if (list.contains(map[ny][nx])) continue;
			
			list.add(map[ny][nx]);
			dfs(ny, nx, cnt + 1);
			list.remove(list.size() - 1);
		}
	}
}
