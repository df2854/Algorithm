import java.io.*;
import java.util.*;

public class Main {
	static int r, c, endY, endX, startY, startX, result;
	static char[][] map;
	static int[][] visited;
	static Queue<int[]> water;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		water = new ArrayDeque<>();
		
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String input = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'D') {
					endY = i;
					endX = j;
				}
				if (map[i][j] == 'S') {
					startY = i;
					startX = j;
				}
				if (map[i][j] == '*') {
					water.offer(new int[] {i, j});
				}
			}
		}
		
		result = simul();
		
		System.out.println(result == -1 ? "KAKTUS" : result);
	}
	
	private static int simul() {
		Queue<int[]> que = new ArrayDeque<>();
		visited = new int[r][c];
		que.offer(new int[] {startY, startX});
		visited[startY][startX] = 1;
		
		while (!que.isEmpty()) {
			int waterSize = water.size();
			for (int i = 0; i < waterSize; i++) {
				int[] cur = water.poll();
				int cy = cur[0];
				int cx = cur[1];

				for (int[] d : dir) {
					int ny = cy + d[0];
					int nx = cx + d[1];
					
					if (ny < 0 || nx < 0 || ny >= r || nx >= c || map[ny][nx] == 'D' || map[ny][nx] == 'X') continue;
					if (map[ny][nx] == '*') continue;
					
					map[ny][nx] = '*';
					water.offer(new int[] {ny, nx});
				}
			}
			
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int[] cur = que.poll();
				int cy = cur[0];
				int cx = cur[1];
				
				for (int[] d : dir) {
					int ny = cy + d[0];
					int nx = cx + d[1];
					
					if (ny < 0 || nx < 0 || ny >= r || nx >= c || map[ny][nx] == 'X' || map[ny][nx] == '*') continue;
					if (visited[ny][nx] != 0) continue;
					
					if (map[ny][nx] == 'D') return visited[cy][cx];
					visited[ny][nx] = visited[cy][cx] + 1;
					que.offer(new int[] {ny, nx});
				}
			}
		}
		return -1;
	}
} 
