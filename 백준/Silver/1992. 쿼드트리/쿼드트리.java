import java.io.*;
import java.util.*;

public class Main {
	static int n, map[][];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		String[] input = new String[n];
		for (int i = 0; i < n; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		divide(0, 0, n);
		
		System.out.println(sb);
	}
	private static void divide(int startY, int startX, int size) {
		int color = check(startY, startX, size);
		if (color == 1) {
			sb.append(color);
			return;
		}
		if (color == 0) {
			sb.append(color);
			return;
		}
		else {
			int newSize = size / 2;
			sb.append("(");
			divide(startY, startX, newSize);
			divide(startY, startX + newSize, newSize);
			divide(startY + newSize, startX, newSize);
			divide(startY + newSize, startX + newSize, newSize);
			sb.append(")");
		}
	}
	private static int check(int startY, int startX, int size) {
		int num = map[startY][startX];
		for (int i = startY; i < startY + size; i++) {
			for (int j = startX; j < startX + size; j++) {
				if (map[i][j] != num) return -1;
			}
		}
		return num;
	}
}