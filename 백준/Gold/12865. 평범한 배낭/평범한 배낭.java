import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[][] arr, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n+1][k+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= arr[i-1][0]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - arr[i-1][0]] + arr[i-1][1]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}
} 
