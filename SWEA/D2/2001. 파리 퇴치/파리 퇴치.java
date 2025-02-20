import java.util.*;
import java.io.*;

class Solution {
	static int n, m, tc, result;
	static int[][] map, sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			sum = new int[n][n+1];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (j == 0) sum[i][1] = map[i][j];
					else {
						sum[i][j+1] = map[i][j] + sum[i][j];
					}
				}
			}
			result = Integer.MIN_VALUE;
			for (int i = 0; i < n - m + 1; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					int tmp = 0;
					for (int k = i; k < i + m; k++) {
						tmp += (sum[k][j + m] - sum[k][j]);
					}
					result = Math.max(result, tmp);
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
