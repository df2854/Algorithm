import java.io.*;
import java.util.*;

class Solution {
	static int tc, n, l;
	static int[][] arr, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			arr = new int[n][2];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp = new int[n+1][l+1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= l; j++) {
					if (j < arr[i-1][1]) dp[i][j] = dp[i-1][j];
					else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - arr[i-1][1]] + arr[i-1][0]);
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(dp[n][l]).append("\n");
		}
		System.out.println(sb);
	}
	
}
