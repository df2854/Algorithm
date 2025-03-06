import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] map;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {0, 0});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			if (cur[0] == n - 1 && cur[1] == m - 1) break;
			
			for (int dir = 0; dir < 4; dir++) {
				int ny = cur[0] + d[dir][0];
				int nx = cur[1] + d[dir][1];
				
				if (ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] == 1) {
					map[ny][nx] += map[cur[0]][cur[1]];
					que.offer(new int[] {ny, nx});
				}
			}
		}
		
		System.out.println(map[n-1][m-1]);
	}
}
