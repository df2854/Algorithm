import java.io.*;
import java.util.*;

public class Main {
	static int n, result;
	static int[][] map;
	static long[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new long[n][n][3];
		dp[0][1][0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 2; j < n; j++) {
				for (int d = 0; d < 3; d++) {
					if (map[i][j] == 1) continue;
					
					if (i == 0) {
						dp[i][j][0] = dp[i][j-1][0];
					}
					
					if (d == 0) {
						dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
					} else if (d == 1 && i >= 1) {
						dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
					} else if (d == 2 && i >= 1) {
						if (map[i-1][j] == 1 || map[i][j-1] == 1) continue;
						dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
					}
				}
			}
		}
		
		System.out.println(dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2]);
	}
} 
