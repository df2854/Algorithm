import java.io.*;
import java.util.*;

public class Main {
	static int n, m, r;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
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
		
		int cnt = Math.min(n, m) / 2; // 돌려야할 배열 수 
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < cnt; j++) {
				int tmp = arr[j][j];
				
				// 위쪽
				for (int k = j + 1; k < m - j; k++) {
					arr[j][k-1] = arr[j][k];
				}
				
				// 오른쪽
				for (int k = j + 1; k < n - j; k++) {
					arr[k-1][m - j - 1] = arr[k][m - j - 1];
				}
				
				// 아래쪽
				for (int k = m - j - 2; k >= j; k--) {
					arr[n - j - 1][k+1] = arr[n - j - 1][k];
				}
				
				// 왼쪽
				for (int k = n - j - 2; k >= j + 1 ; k--) {
					arr[k+1][j] = arr[k][j];
				}
				
				arr[j + 1][j] = tmp;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb + "\n");
		bw.flush();
		bw.close();
	}
}
