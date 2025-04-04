import java.io.*;
import java.util.*;

public class Main {
	static int tc, n, k, result;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		dp = new int[30][30];
		
		for (int i = 0; i <= 29; i++) {
			for (int j = 0; j <= Math.min(i, 29); j++) {
				if (j == 0 || i == j) dp[i][j] = 1;
				else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
	
			sb.append(dp[k][n]).append("\n");
		}
		
		System.out.println(sb);
	}
}
