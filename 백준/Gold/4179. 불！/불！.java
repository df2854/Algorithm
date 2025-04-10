import java.io.*;
import java.util.*;

public class Main {
	static int r, c, startY, startX, result;
	static char[][] map;
	static int[][] visited;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static Queue<int[]> fire;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		
		fire = new ArrayDeque<>();
		for (int i = 0; i < r; i++) {
			String input = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'J') {
					startY = i;
					startX = j;
				}
				if (map[i][j] == 'F') {
					fire.offer(new int[] {i, j});
				}
			}
		}
		
		result = simulate();
		
		System.out.println(result == -1 ? "IMPOSSIBLE" : result);
	}
	private static int simulate() {
		Queue<int[]> que = new ArrayDeque<>();
		visited = new int[r][c];
		que.offer(new int[] {startY, startX});
		visited[startY][startX] = 1;
		
		while(!que.isEmpty()) {
			int fireSize = fire.size();
			for (int i = 0; i < fireSize; i++) {
				int[] cur = fire.poll();
				int cy = cur[0];
				int cx = cur[1];
				
				for (int[] d : dir) {
					int ny = cy + d[0];
					int nx = cx + d[1];
					
					if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
					if (map[ny][nx] == '#' || map[ny][nx] == 'F') continue;
					
					map[ny][nx] = 'F';
					fire.offer(new int[] {ny, nx});
				}
			}
			
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int[] cur = que.poll();
				int cy = cur[0];
				int cx = cur[1];
				
				if (cy == 0 || cy == r-1 || cx == 0 || cx == c-1) {
					return visited[cy][cx];
				}
				
				for (int[] d : dir) {
					int ny = cy + d[0];
					int nx = cx + d[1];
					
					if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
					if (map[ny][nx] != '.' || visited[ny][nx] != 0) continue;
					
					visited[ny][nx] = visited[cy][cx] + 1;
					que.offer(new int[] {ny, nx});
				}
			}
		}
		
		return -1;
	}
} 
