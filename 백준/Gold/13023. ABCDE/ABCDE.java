import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static List<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			visited[i] = true;
			if (dfs(i, 0) == 1) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	private static int dfs(int idx, int depth) {
		if (depth == 4) {
			return 1;
		}
		for (int num : list[idx]) {
			if (!visited[num]) {
				visited[num] = true;
				if (dfs(num, depth+1) == 1) {
					return 1;
				}
				visited[num] = false;
			}
		}
		return 0;
	}
}
