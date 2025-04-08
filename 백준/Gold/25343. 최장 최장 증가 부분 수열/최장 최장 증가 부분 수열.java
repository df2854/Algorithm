import java.io.*;
import java.util.*;

public class Main {
	static int n, max;
	static int[][] map, dp;

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
		
		
		dp = new int[n][n];
		
		max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = 1;
				for (int k = 0; k <= i; k++) {
					for (int l = 0; l <= j; l++) {
						if (map[i][j] > map[k][l]) {
							dp[i][j] = Math.max(dp[i][j], dp[k][l] + 1);
						}
					}
				}
				
				max = Math.max(max, dp[i][j]);
			}
		}
		
		System.out.println(max);
	}
} 
