import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] result;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		result = new int[m];
		visited = new boolean[n+1];
		
		dfs(0);
	}
	private static void dfs(int idx) {
		if (idx == m) {
			print(result);
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (visited[i]) continue;
			
			result[idx] = i;
			visited[i] = true;
			
			dfs(idx + 1);
			
			visited[i] = false;
		}
	}
	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
