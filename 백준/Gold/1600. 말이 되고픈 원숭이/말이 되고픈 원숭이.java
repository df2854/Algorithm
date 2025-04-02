import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int y, x, horseCnt;

		public Point(int y, int x, int horseCnt) {
			super();
			this.y = y;
			this.x = x;
			this.horseCnt = horseCnt;
		}
	}
	static int k, w, h, result;
	static int[][] map;
	static int[][][] visited;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][] dirHorse = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new int[h][w][k+1];
		Queue<Point> que = new ArrayDeque<>();
		que.offer(new Point(0, 0, 0));
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++)
			Arrays.fill(visited[i][j], -1);
		}
		visited[0][0][0] = 0;
		
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			int cy = cur.y;
			int cx = cur.x;
			
			for (int[] d : dir) {
				int ny = cy + d[0];
				int nx = cx + d[1];
				
				if (ny < 0 || ny >= h || nx < 0 || nx >= w || map[ny][nx] == 1) continue;
				if (visited[ny][nx][cur.horseCnt] != -1) continue;
				
				visited[ny][nx][cur.horseCnt] = visited[cy][cx][cur.horseCnt] + 1;
				que.offer(new Point(ny, nx, cur.horseCnt));
			}
			
			if (cur.horseCnt >= k) continue;
			
			for (int[] d : dirHorse) {
				int ny = cy + d[0];
				int nx = cx + d[1];
				
				if (ny < 0 || ny >= h || nx < 0 || nx >= w || map[ny][nx] == 1) continue;
				if (visited[ny][nx][cur.horseCnt + 1] != -1) continue;
				
				visited[ny][nx][cur.horseCnt + 1] = visited[cy][cx][cur.horseCnt] + 1;
				que.offer(new Point(ny, nx, cur.horseCnt + 1));
			}
		}
		
		result = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            if (visited[h-1][w-1][i] != -1) {
                result = Math.min(result, visited[h-1][w-1][i]);
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1); 
        } else {
            System.out.println(result);
        }
	}
}
