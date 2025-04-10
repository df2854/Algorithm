import java.io.*;
import java.util.*;

public class Main {
	static int tc, n, startY, startX, endY, endX;
	static List<int[]> adjList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				adjList.add(new int[] {x, y});
			}
			
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());

			System.out.println(bfs());
		}
	}
	
	private static String bfs() {
		Queue<int[]> que = new ArrayDeque<>();
		visited = new boolean[n];
		
		que.offer(new int[] {startX, startY});
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			if (Math.abs(cx - endX) + Math.abs(cy - endY) <= 1000) {
				return "happy";
			}
			
			for (int i = 0; i < n; i++) {
				int nx = adjList.get(i)[0];
				int ny = adjList.get(i)[1];
				
				if (visited[i]) continue;
				
				if (Math.abs(cx - nx) + Math.abs(cy - ny) <= 1000) {
					visited[i] = true;
					que.offer(new int[] {nx, ny});
				}
			}
		}
		
		return "sad";
	}
} 
