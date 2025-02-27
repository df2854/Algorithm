import java.io.*;
import java.util.*;

public class Solution {
	static int n, count, result;
	static int[][] map;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = Integer.MAX_VALUE;
			count = Integer.MIN_VALUE;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dfs(i, j, 1, i, j);
				}
			}
			
			System.out.println("#" + t + " " + result + " " + count);
		}
	}
	private static void dfs(int r, int c, int cnt, int startR, int startC) {
		boolean flag = false;
		for (int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
				if (map[r][c] == map[nr][nc] - 1) {
					flag = true;
					dfs(nr, nc, cnt + 1, startR, startC);
				}
			}
		}
		
		if (!flag) {
			if (cnt > count) {
			    count = cnt;
			    result = map[startR][startC];
			} else if (cnt == count) {
			    if (map[startR][startC] < result) {
			        result = map[startR][startC];
			    }
			}
			
			return;
		}
	}
}
