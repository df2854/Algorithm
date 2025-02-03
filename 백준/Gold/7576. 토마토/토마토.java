import java.io.*;
import java.util.*;

class Point {
	int y;
	int x;

	Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(input[j]);
			}
		}

		int dy[] = {-1, 0, 1, 0};
		int dx[] = {0, 1, 0, -1};
		
		Queue<Point> que = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 1) {
					que.offer(new Point(i, j));
				}
			}
		}

		while (!que.isEmpty()) {
			Point cur = que.poll();
			int cy = cur.y;
			int cx = cur.x;
			for (int dir = 0; dir < 4; dir++) {
				int ny = cy + dy[dir];
				int nx = cx + dx[dir];
				if (ny >= 0 && ny < n && nx >= 0 && nx < m && graph[ny][nx] == 0) {
					que.offer(new Point(ny, nx));
					graph[ny][nx] = graph[cy][cx] + 1;
				}
			}
		}

		int result = Integer.MIN_VALUE;
		out: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 0) {
					result = 0;
					break out;
				} else if (graph[i][j] > 0) {
					result = Math.max(result, graph[i][j]);
				}
			}
		}

		System.out.println(result - 1);
	}
}
