import java.io.*;
import java.util.*;

public class Main {
	static int w, h, result;
	static int[][] map;
	static int[][] d = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true ) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 &&  h == 0) break;
			
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			result = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						result++;
						Queue<int[]> que = new ArrayDeque<>();
						que.offer(new int[] {i, j});
						map[i][j] = -1;
						while(!que.isEmpty()) {
							int[] cur = que.poll();
							for (int dir = 0; dir < 8; dir++) {
								int ny = cur[0] + d[dir][0];
								int nx = cur[1] + d[dir][1];
								
								if (ny >= 0 && ny < h && nx >= 0 && nx < w && map[ny][nx] == 1) {
									map[ny][nx] = -1;
									que.offer(new int[] {ny, nx});
								}
							}
						}
					}
				}
			}	
			
			System.out.println(result);
		}
	}
}
