import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] result;
	static List<Integer>[] list;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		result = new int[n+1];
		
		dfs(1, 0);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	private static void dfs(int node, int parent) {
		for (int i : list[node]) {
			if (i != parent) {
				dfs(i, node);
				result[i] = node;
			}
		}
	}
}