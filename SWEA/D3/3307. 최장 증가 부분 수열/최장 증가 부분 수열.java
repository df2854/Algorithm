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
			
			result = 0;
			for (int i = 0; i < n; i++) {
				int pos = Arrays.binarySearch(dp, 0, result, num[i]);
				if (pos >= 0) return;
				int temp = Math.abs(pos) - 1;
				
				dp[temp] = num[i];
				
				if (temp == result) ++result;
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
