import java.io.*;
import java.util.*;

class Solution {
	static int tc, n, result;
	static int[][] map;
	static int[][] dir = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	static boolean[][] visited;
	static List<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[n][n];
			list = new ArrayList<Integer>();
			result = -1;
			
			for (int i = 0; i < n - 2; i++) {
				for (int j = 1; j < n - 1; j++) {
					list.add(map[i][j]);
					int ny = i + dir[0][0];
					int nx = j + dir[0][1];
					if (!list.contains(map[ny][nx])) {
						list.add(map[ny][nx]);
						visited[ny][nx] = true;
						dfs(ny, nx, 0, i, j);
						list.remove(list.size() - 1);
						visited[ny][nx] = false;
					}
					list.remove(0);
				}
			}
			
			bw.write("#" + t + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	private static void dfs(int y, int x, int direction, int startY, int startX) {
//		System.out.println(list + " " + y + " : " + x + ", " + startY + " : " + startX);
		if (y + dir[3][0] == startY && x + dir[3][1] == startX) {
			result = Math.max(result, list.size());
			return;
		}
		
		if (direction == 3) {
			int ny = y + dir[direction][0];
			int nx = x + dir[direction][1];
			
			if (ny >= startY && ny < n && nx >= 0 && ny < n && !visited[ny][nx] && !list.contains(map[ny][nx])) {
				list.add(map[ny][nx]);
				visited[ny][nx] = true;
				dfs (ny, nx, direction, startY, startX);
				visited[ny][nx] = false;
				list.remove(list.size()-1);
			}
		} else {
			for (int d = direction; d < direction + 2; d++) {
				int ny = y + dir[d][0];
				int nx = x + dir[d][1];
				if (ny < startY || ny >= n || nx < 0 || nx >= n) continue;
				if (visited[ny][nx]) continue;
				if (list.contains(map[ny][nx])) continue;
				
				list.add(map[ny][nx]);
				visited[ny][nx] = true;
				dfs (ny, nx, d, startY, startX);
				visited[ny][nx] = false;
				list.remove(list.size()-1);
			}
		}
	}
}