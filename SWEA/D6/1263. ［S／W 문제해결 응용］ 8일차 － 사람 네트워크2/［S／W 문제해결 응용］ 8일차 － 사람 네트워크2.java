import java.io.*;
import java.util.*;

class Solution {
	static final int INF = 100000;
	static int tc, n, k, minCC;
	static int[][] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			
			dist = new int[n+1][n+1];
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (i == j) {
						dist[i][j] = 0;
					} else {
						dist[i][j] = num == 1 ? 1 : INF;
					}
				}
			}
			
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
			
			minCC = Integer.MAX_VALUE;
			for (int i = 1; i <= n; i++) {
				int sum = 0;
				for (int j = 1; j <= n; j++) {
					sum += dist[i][j];
				}
				
				minCC = Math.min(minCC, sum);
			}
			
			sb.append("#").append(t).append(" ").append(minCC).append("\n");
		}
		System.out.println(sb);
	}
}
