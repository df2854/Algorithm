import java.io.*;
import java.util.*;

public class Main {
	static int n, m, r, arr[][], count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count = Math.min(n, m) / 2;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < count; j++) {
				int tmp = arr[j][j];
				
				for (int k = j + 1; k < m - j; k++) {
					arr[j][k-1] = arr[j][k];
				}
				
				for (int k = j + 1; k < n - j; k++) {
					arr[k-1][m-1-j] = arr[k][m-1-j];
				}
				
				for (int k = m - 2 - j; k >= j; k--) {
					arr[n-1-j][k+1] = arr[n-1-j][k];
				}
				
				for (int k = n - 2 - j; k >= j + 1; k--) {
					arr[k+1][j] = arr[k][j];
				}
				
				arr[j+1][j] = tmp;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}