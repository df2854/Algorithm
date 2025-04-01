import java.io.*;
import java.util.*;

class Solution {
	static class Node {
		int y, x, dist, distType;

		public Node(int y, int x, int dist, int distType) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
			this.distType = distType;
		}
	}
	static int tc, startX, startY, endX, endY, result;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static boolean[][][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			result = -1;
			
			visited = new boolean[201][201][2];
			
			int sy = startY + 100;
			int sx = startX + 100;
			int ey = endY + 100;
			int ex = endX + 100;

			Queue<Node> que = new ArrayDeque<>();
			
			que.offer(new Node(sy, sx, 0, 0));
			que.offer(new Node(sy, sx, 0, 1));
			
			visited[sy][sx][0] = true;
			visited[sy][sx][1] = true;
			
			while(!que.isEmpty()) {
				Node cur = que.poll();
				int cy = cur.y;
				int cx = cur.x;
				
				if (cy == ey && cx == ex) {
					result = cur.dist;
					break;
				}
				
				for (int d = 0; d < 4; d++) {
					int nextDir = d % 2 == 0 ? 0 : 1;
					
					if (nextDir == cur.distType) continue;
					
					int ny = cy + dy[d];
					int nx = cx + dx[d];
					
					if (ny > 200 || nx > 200 || ny < 0 || nx < 0) continue;
					if (visited[ny][nx][nextDir]) continue;
					
					visited[ny][nx][nextDir] = true;
					que.offer(new Node(ny, nx, cur.dist + 1, nextDir));
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
