import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			dp[i][i] = 1; // 1
			
			if (i+1 <= n && arr[i] == arr[i+1]) { // 2
				dp[i][i+1] = 1;
			}
		}
		
		for (int size = 3; size <= n; size++) {
			for (int i = 1; i <= n - size + 1; i++) {
				int j = i + size - 1;
				if (arr[i] == arr[j] && dp[i+1][j-1] == 1) {
					dp[i][j] = 1;
				}
			}
		}
		
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sb.append(dp[s][e]).append("\n");
		}
		
		System.out.println(sb);
	}	
}
