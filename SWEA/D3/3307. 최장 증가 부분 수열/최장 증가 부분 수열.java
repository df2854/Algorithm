import java.io.*;
import java.util.*;

class Solution {
	static int tc, n, result;
	static int[] num, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			num = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[n];
			Arrays.fill(dp, 1);
			
			result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (num[i] > num[j] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
				result = Math.max(result, dp[i]);
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
