import java.util.*;
import java.io.*;

class Main {
	private static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				if (input.charAt(j) == 'B') matrix[i][j] = 0;
				else if (input.charAt(j) == 'W') matrix[i][j] = 1;
			}
		}
		
		result = Integer.MAX_VALUE;
		
		for (int i = 0; i <= n-8; i++) {
			for (int j = 0; j <= m-8; j++) {
				int a = bruteForce(matrix, i, j, 0);
				int b = bruteForce(matrix, i, j, 1);
				result = Math.min(result, Math.min(a, b));
			}
		}
		
		System.out.println(result);
	}
	
	private static int bruteForce(int[][] arr, int a, int b, int color) {
		int count = 0;

		for (int i = a; i <= a+7; i++) {
			for (int j = b; j <= b+7; j++) {
				if (((i - a) % 2 == 0 && (j - b) % 2 == 0) && arr[i][j] != color) {
					count++;
				} else if (((i - a) % 2 == 0 && (j - b) % 2 == 1) && arr[i][j] == color) {
					count++;
				} else if (((i - a) % 2 == 1 && (j - b) % 2 == 1) && arr[i][j] != color) {
					count++;
				} else if (((i - a) % 2 == 1 && (j - b) % 2 == 0) && arr[i][j] == color) {
					count++;
				}
				
				if (count >= result) return Integer.MAX_VALUE;
			}
		}
		
		return count;
	}
}
