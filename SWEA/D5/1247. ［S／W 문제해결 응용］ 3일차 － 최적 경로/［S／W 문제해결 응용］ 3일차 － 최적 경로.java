import java.util.*;
import java.io.*;

class Solution {
	static int tc, n, startY, startX, endY, endX, result;
	static List<int[]> list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[] {y, x});
			}
			
			visited = new boolean[n];
			result = Integer.MAX_VALUE;
			
			dfs(0, 0, startY, startX);
			
			System.out.println("#" + t + " " + result);
		}
	}
	private static void dfs(int idx, int sum, int y, int x) {
		if (idx == n) {	
			result = Math.min(result, sum + (Math.abs(y - endY) + Math.abs(x - endX)));
			return;
		}
		
		if (sum > result) return;
		
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			
			int ny = list.get(i)[0];
			int nx = list.get(i)[1];
			visited[i] = true;
			
			dfs(idx + 1, sum + (Math.abs(ny - y) + Math.abs(nx - x)), ny, nx);
			
			visited[i] = false;
		}
	}
}
