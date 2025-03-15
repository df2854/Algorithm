/*
접근 방법 : dp의 knapsack 문제 
*/

import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[] arr;
	static int[][] dp;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[n][k+1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], k+1);
			dp[i][0] = 0;
		}
		
		for (int i = 1; i <= k; i++) {
			if (i % arr[0] == 0) {
				dp[0][i] = i / arr[0];
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= arr[i]) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j - arr[i]] + 1);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		
		if (dp[n - 1][k] == k + 1) {
		    System.out.println(-1);
		} else {
		    System.out.println(dp[n - 1][k]);
		}
	}
}