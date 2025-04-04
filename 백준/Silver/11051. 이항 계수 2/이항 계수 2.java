import java.io.*;
import java.util.*;

public class Main {
	static final int MOD = 10007;
	static int n, k, result;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1][k+1];
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || i == j) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i-1][j-1] % MOD + dp[i-1][j] % MOD) % MOD;
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
