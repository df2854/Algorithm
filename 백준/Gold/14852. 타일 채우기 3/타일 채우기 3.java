import java.io.*;
import java.util.*;

public class Main {
	static final int MOD = 1_000_000_007;
	static int n, result;
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		if (n == 1) {
			System.out.println(2);
			return;
		}
		
		dp = new long[n+1];
	
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 7;
		
		// 누적합 변수
		long sum = 1;  // dp[0]
		
		for (int i = 3; i <= n; i++) {
			dp[i] = (2 * dp[i - 1] + 3 * dp[i - 2] + 2 * sum) % MOD;
			sum = (sum + dp[i - 2]) % MOD;
		}
		
		System.out.println(dp[n]);
	}
}
