import java.util.*;
import java.io.*;

public class Main {
	static int n, map[][], max, result;
	static boolean visited[][];
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException {
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		max = Integer.MIN_VALUE;
		result = Integer.MIN_VALUE;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		
		for (int i = 0; i <= max; i++) {
			result = Math.max(result, calc(i, 0));
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
	private static int calc(int score, int cnt) {
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] > score && !visited[i][j]) {
					Queue<int[]> que = new ArrayDeque<>();
					que.offer(new int[]{i, j});
					visited[i][j] = true;
					cnt += 1;
					while(!que.isEmpty()) {
						int[] cur = que.poll();
						int cy = cur[0];
						int cx = cur[1];
						
						for (int dir = 0; dir < 4; dir++) {
							int ny = cy + d[dir][0];
							int nx = cx + d[dir][1];
							if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx] && map[ny][nx] > score) {
								visited[ny][nx] = true;
								que.offer(new int[]{ny, nx});
							}
						}
					}
				}
			}
		}
		
		return cnt;
	}
}
