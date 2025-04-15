import java.util.*;
import java.io.*;

class Solution {
	static final int MOD = 1234567891;
	static int tc, n, r;
	static long[] f;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			f = new long[n+1];
			f[1] = 1;
			
			for (int i = 2; i <= n; i++) {
				f[i] = (f[i-1] * i) % MOD;
			}
			
			long bottom = (f[r] * f[n-r]) % MOD;
			long reverse = pow(bottom, MOD-2);
			
			long result = (f[n] * reverse) % MOD;
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	private static long pow (long a, long b) {
		if (b == 0) {
			return 1;
		}
		else if (b == 1) {
			return a;
		}
		
		if (b % 2 == 0) {
			long tmp = pow(a, b / 2);
			return (tmp * tmp) % MOD;
		}
		
		long tmp = pow(a, b - 1);
		return (tmp * a) % MOD;
	}
}
