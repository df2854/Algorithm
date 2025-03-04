import java.io.*;
import java.util.*;

public class Solution {
	static int n, count, result;
	static String keyword;
	static int[][] map, answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			keyword = st.nextToken();
			
			map = new int[n][n];
			answer = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if (keyword.equals("up")) {
				up();
			} else if (keyword.equals("down")) {
				down();
			} else if (keyword.equals("right")) {
				right();
			} else if (keyword.equals("left")) {
				left();
			}
			
			bw.write("#" + t + "\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					bw.write(answer[i][j] + " ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}

	private static void left() {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (map[i][j] == 0) continue;
				
				int idx = j + 1;
				while (map[i][idx] == 0) {
					if (idx == n-1) break;
					idx++;
				}
				
				if (map[i][idx] == 0) continue;
				
				if (map[i][j] == map[i][idx]) {
					map[i][j] += map[i][idx];
					map[i][idx] = 0;
					j = idx;
				}
			}
			
			int cur = 0;
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) {
					answer[i][cur++] = map[i][j];
				}
			}
		}
	}

	private static void right() {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = n -1; j > 0; j--) {
				if (map[i][j] == 0) continue;
				
				int idx = j - 1;
				while (map[i][idx] == 0) {
					if (idx == 0) break;
					idx--;
				}
				
				if (map[i][idx] == 0) continue;
				
				if (map[i][j] == map[i][idx]) {
					map[i][j] += map[i][idx];
					map[i][idx] = 0;
					j = idx;
				}
			}
			
			int cur = n-1;;
			for (int j = n-1; j >= 0; j--) {
				if (map[i][j] != 0) {
					answer[i][cur--] = map[i][j];
				}
			}
		}
	}

	private static void down() {
		// TODO Auto-generated method stub
		for (int j = 0; j < n; j++) {
			for (int i = n - 1; i > 0; i--) {
				if (map[i][j] == 0) continue;
				
				int idx = i - 1;
				while(map[idx][j] == 0) {
					if(idx == 0) break;
					idx--;
				}
				
				if (map[idx][j] == 0) continue;
				
				if (map[i][j] == map[idx][j]) {
					map[i][j] += map[idx][j];
					map[idx][j] = 0;
					i = idx;
				}
			}
			
			int cur = n-1;
			for (int i = n-1; i >= 0; i--) {
				if (map[i][j] != 0) {
					answer[cur--][j] = map[i][j];
				}
			}
		}
	}

	private static void up() {
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n-1; i++) {
				if (map[i][j] == 0) continue;
				
				int idx = i + 1;
				while (map[idx][j] == 0) {
					if (idx == n - 1) break;
					idx++;
				}
				
				if (map[idx][j] == 0) {
					continue;
				}
				
				if (map[i][j] == map[idx][j]) {
					map[i][j] += map[idx][j];
					map[idx][j] = 0;
					i = idx;
				}
			}
			int cur = 0;
			for (int i = 0; i < n; i++) {
				if (map[i][j] != 0) {
					answer[cur++][j] = map[i][j];
				}
			}
		}
	}
	
}
