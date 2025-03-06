import java.io.*;
import java.util.*;

class Solution {
	static int tc, n, max, result;
	static int[][] map;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			max = 0;
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			result = Integer.MIN_VALUE;
			
			for (int k = 0; k <= max; k++) {
				int cnt = 0;
				visited = new boolean[n][n];;
				Queue<int[]> que = new ArrayDeque<>();
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (map[i][j] > k && !visited[i][j]) {
							que.offer(new int[] {i, j});
							cnt++;
							while (!que.isEmpty()) {
								int[] cur = que.poll();
								int cy = cur[0];
								int cx = cur[1];
								
								for (int dir = 0; dir < 4; dir++) {
									int ny = cy + d[dir][0];
									int nx = cx + d[dir][1];
									
									if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx] && map[ny][nx] > k) {
										visited[ny][nx] = true;
										que.offer(new int[] {ny, nx});
									}
								}
							}
						}
					}
				}
				result = Math.max(result, cnt);
			}
			
			bw.write("#" + t + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
