import java.io.*;
import java.util.*;

public class Main {
	static int n, m, result;
	static int[] a, c;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		c = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n+1][10001];
		
		result = Integer.MAX_VALUE;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= 10000; j++) {
				if (j >= c[i-1]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - c[i-1]] + a[i-1]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
				
				if (dp[i][j] >= m) {
					result = Math.min(result, j);
				}
			}
		}
		
		System.out.println(result);
	}
} 
