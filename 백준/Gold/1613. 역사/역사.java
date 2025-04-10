import java.io.*;
import java.util.*;

public class Main {
	static int n, k, s;
	static int[][] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		adj = new int[n+1][n+1];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			adj[start][end] = -1;
			adj[end][start] = 1;
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (adj[i][k] == 1 && adj[k][j] == 1) adj[i][j] = 1;
					if (adj[i][k] == -1 && adj[k][j] == -1) adj[i][j] = -1;
				}
			}
		}
		
		s = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(adj[start][end]).append("\n");
		}
		
		System.out.println(sb);
	}
} 
