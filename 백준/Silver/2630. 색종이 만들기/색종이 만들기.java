import java.util.*;
import java.io.*;

public class Main {
	static int n, map[][], white, blue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		white = 0;
		blue = 0;
		
		solve(0, 0, n);
		
		bw.write(white + "\n" + blue + "\n");

		bw.flush();
		bw.close();
	}
	private static void solve(int startY, int startX, int size) {
		int color = check(startY, startX, size);
		if (color == 0) {
			white++;
			return;
		}
		if (color == 1) {
			blue++;
			return;
		}
		
		solve(startY, startX, size/2);
		solve(startY, startX + size/2, size/2);
		solve(startY + size/2, startX, size/2);
		solve(startY + size/2, startX + size/2, size/2);
	}
	
	private static int check(int startY, int startX, int size) {
		int color = map[startY][startX];
		for (int i = startY; i < startY + size; i++) {
			for (int j = startX; j < startX + size; j++) {
				if (map[i][j] != color) return -1;
			}
		}
		return color;
	}
}
