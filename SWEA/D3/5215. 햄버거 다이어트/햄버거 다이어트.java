import java.util.*;
import java.io.*;

class Solution {
	static int[][] ham;
	static int n, l, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			ham = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				ham[i][0] = Integer.parseInt(st.nextToken());
				ham[i][1] = Integer.parseInt(st.nextToken());
			}
			
			result = 0;
			dfs(0, 0, 0);
			
			System.out.println("#" + t + " " + result);
		}
	}
	private static void dfs(int cnt, int score, int cal) {
		if (cnt == n) {
			result = Math.max(result, score);
			return;
		}
		
		if (cal + ham[cnt][1] <= l) {
			dfs (cnt + 1, score + ham[cnt][0], cal + ham[cnt][1]);
		} 
		if (cal <= l) {
			dfs (cnt + 1, score, cal);
		}
	}
}
