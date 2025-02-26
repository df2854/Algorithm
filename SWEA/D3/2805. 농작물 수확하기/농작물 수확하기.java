import java.util.*;
import java.io.*;

class Solution {
	static int n, map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			input = new String[n];
			for (int i = 0; i < n; i++) {
				input = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			int h = n / 2;
			int result = 0;
			
			for (int i = 0; i < n; i++) {
				if (i <= h) {
					for (int j = h - i; j < h + i + 1; j++) {
						result += map[i][j];
					}
				} else {
					for (int j = i - h; j < n - (i - h); j++) {
						result += map[i][j];
					}
				}
			}
			
			bw.write("#" + t + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
