import java.io.*;
import java.util.*;

class Solution {
	static int tc, n, k;
	static int[][] bag, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			bag = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				bag[i][0] = Integer.parseInt(st.nextToken());
				bag[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[n+1][k+1];
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= k; j++) {
					if (bag[i-1][0] <= j) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - bag[i-1][0]] + bag[i-1][1]);
					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(dp[n][k]).append("\n");
		}
		System.out.println(sb);
	}
}
