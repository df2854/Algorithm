import java.util.*;
import java.io.*;

class Solution {
	static int n, ans;
	static int[][] synergy;
	static boolean[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			synergy = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			selected = new boolean[n];
			
			ans = Integer.MAX_VALUE;
			
			comb(0, 0);
			
			bw.write("#" + t + " " + ans + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void comb(int idx, int cnt) {
		if (cnt == n / 2) {
			calc();
			return;
		}
		
		for (int i = idx; i < n; i++) {
			selected[i] = true;
			comb(i+1, cnt+1);
			selected[i] = false;
		}
	}
	
	public static void calc() {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (i == j) continue;
				if (selected[i] && selected[j]) {
					sum1 += (synergy[i][j] + synergy[j][i]);
				} else if (!selected[i] && !selected[j]) {
					sum2 += (synergy[i][j] + synergy[j][i]);
				}
			}
		}
		
		ans = Math.min(ans, Math.abs(sum1 - sum2));
	}
}