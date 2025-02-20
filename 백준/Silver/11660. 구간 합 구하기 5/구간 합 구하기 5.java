import java.io.*;
import java.util.*;

public class Main {
	static int n, m, sum1, sum2;
	static int[][] arr, sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		sum = new int[n+1][n+1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(j == 0) {
					sum[i+1][j+1] = arr[i][j];
				} else {
					sum[i+1][j+1] = sum[i+1][j] + arr[i][j];
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int ans = 0;
			for (int j = y1; j <= y2; j++) {
				ans += (sum[j][x2] - sum[j][x1-1]);
			}
			System.out.println(ans);
		}
	}
}
