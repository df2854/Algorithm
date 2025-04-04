import java.io.*;
import java.util.*;

class Solution {
	static int tc;
	static int[] charge, month, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			charge = new int[4];
			month = new int[12];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				charge[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[13];
			
			for (int i = 1; i <= 12; i++) {
				dp[i] = dp[i-1] + charge[0] * month[i-1];
				
				dp[i] = Math.min(dp[i], dp[i-1] + charge[1]);
				
				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i-3] + charge[2]);
				}
			}
			
			dp[12] = Math.min(dp[12], charge[3]);
			sb.append("#").append(t).append(" ").append(dp[12]).append("\n");
		}
		System.out.println(sb);
	}
	
}
