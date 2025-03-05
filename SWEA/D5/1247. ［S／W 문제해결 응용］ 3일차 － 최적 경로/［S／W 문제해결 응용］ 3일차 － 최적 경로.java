import java.io.*;
import java.util.*;

public class Solution {
	static int tc, n, result, endX, endY;
	static boolean[] visited;
	static List<int[]> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			// 회사 위치
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			// 집 위치
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			for (int i = 0; i < n; i++) { // 고개들 집 위치
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[]{x, y});
			}
			
			visited = new boolean[n];			
			result = Integer.MAX_VALUE;
			
			dfs(0, 0, startX, startY);
			
			bw.write("#" + t + " " + result + "\n");
			
		}
		bw.flush();
		bw.close();
	}
	private static void dfs(int idx, int sum, int startX, int startY) {
		if (idx == n) {
			result = Math.min(result, sum + Math.abs(startX - endX) + Math.abs(startY - endY));
			return;
		}
		
		if (sum > result) return;
		
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			
			dfs(idx + 1, sum + Math.abs(startX - x) + Math.abs(startY - y), x, y);
			
			visited[i] = false;
		}
	}

}
