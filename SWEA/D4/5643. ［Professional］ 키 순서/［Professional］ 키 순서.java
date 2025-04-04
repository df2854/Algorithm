import java.io.*;
import java.util.*;

class Solution {
	static int tc, n, m, result;
	static List<Integer>[] list, reverseList;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			
			list = new ArrayList[n+1];
			reverseList = new ArrayList[n+1];
			for (int i = 0; i <= n; i++) {
				list[i] = new ArrayList<>();
				reverseList[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				list[from].add(to);
				reverseList[to].add(from);
			}
			
			result = 0;
			
			for (int i = 1; i <= n; i++) {
				visited = new boolean[n+1];
				int parent = dfs(i);
				int child = reverseDFS(i);
				
				if (parent + child == n - 1) result++;
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	private static int dfs(int start) {
		visited[start] = true;
		int cnt = 0;
		
		for (int num : list[start]) {
			if (!visited[num]) {
				cnt++;
				cnt += dfs(num);
			}
		}
		
		return cnt;
	}
	
	private static int reverseDFS(int start) {
		visited[start] = true;
		int cnt = 0;
		
		for (int num : reverseList[start]) {
			if (!visited[num]) {
				cnt++;
				cnt += reverseDFS(num);
			}
		}
		
		return cnt;
	}
}
