import java.io.*;
import java.util.*;

class Solution {
	static int tc, n, result;
	static String[][] map;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			map = new String[n][n];
			for (int i = 0; i < n; i++) {
				input = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					map[i][j] = input[j];
				}
			}
			
			result = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j].equals(".")) {
						boolean flag = true;
						for (int dir = 0; dir < 8; dir++) {
							int ny = i + d[dir][0];
							int nx = j + d[dir][1];
							
							if (isRange(ny, nx) && map[ny][nx].equals("*")) {
								flag = false;
								break;
							}
						}
						
						if (flag) {
							bfs(i, j);
							result++;
						}
					}
				}
			}
			

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j].equals(".")) {
						bfs(i, j);
						result++;
					}
				}
			}

			bw.write("#" + t + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
	private static void bfs(int y, int x) {
		if (map[y][x].equals(".")) {
			Queue<int[]> que = new ArrayDeque<>();
			que.offer(new int[] {y, x});
			map[y][x] = "0";
			
			while(!que.isEmpty()) {
				boolean flag = false;
				int[] cur = que.poll();
				int cy = cur[0];
				int cx = cur[1];
				
				for (int dir = 0; dir < 8; dir++) {
					int ny = cy + d[dir][0];
					int nx = cx + d[dir][1];
					
					if (!isRange(ny, nx)) continue;
					
					if (map[ny][nx].equals("*")) {
						map[cy][cx] = String.valueOf(Integer.parseInt(map[cy][cx]) + 1);
						flag = true;
					}
				}
				if (!flag) {
					for (int dir = 0; dir < 8; dir++) {
						int ny = cy + d[dir][0];
						int nx = cx + d[dir][1];
						
						if (isRange(ny, nx) && map[ny][nx].equals(".")) {
							map[ny][nx] = "0";
							que.offer(new int[] {ny, nx});
						}
					}
				}
			}
		}
	}
	
	private static boolean isRange(int y, int x) {
		if (y >= 0 && y < n && x >= 0 && x < n) return true;
		return false;
	}
}