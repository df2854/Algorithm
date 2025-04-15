import java.io.*;
import java.util.*;

public class Main {
	static int tc, n, result;
	static boolean[] visited, cycle;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			result = 0;
			visited = new boolean[n+1];
			cycle = new boolean[n+1];
			
			arr = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				
				if (arr[i] == i) {
					result++;
					cycle[i] = true;
				}
			}
			

			for (int i = 1; i <= n; i++) {
				if (!cycle[i]) {
					dfs(i);
				}
			}
			
			sb.append(n - result).append("\n");
		}
		
		System.out.println(sb);
	}
	private static void dfs(int n) {
		if (visited[n]) {
			cycle[n] = true;
			result++;
		} else {
			visited[n] = true;
		}
		
		int next = arr[n];
		
		if (!cycle[next]) {
			dfs(next);
		}
		
		visited[n] = false;
		cycle[n] = true;
	}	
}
