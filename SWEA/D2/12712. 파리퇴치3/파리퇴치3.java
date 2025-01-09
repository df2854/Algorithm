import java.io.*;
import java.util.*;

class Solution
{
    static int n, m;
	static int[][] graph;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static int[] dys = {-1, 1, 1, -1};
	static int[] dxs = {1, 1, -1, -1};
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			graph = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			int maxValue = Integer.MIN_VALUE;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int sum1 = result1(i, j);
					int sum2 = result2(i, j);
					int tmp = sum1 > sum2 ? sum1 : sum2;
					
					if (maxValue < tmp) {
						maxValue = tmp;
					}
				}
			}
			bw.write("#" + t + " " + maxValue + "\n");
		}
		bw.close();
	}
    
    public static boolean inRange(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}
	
	public static int result1(int y, int x) {
		int sum = graph[y][x];
		for(int i = 1; i < m; i++) {
			for (int dir = 0; dir < 4; dir++) {
				if (inRange(y + i * dy[dir], x + i * dx[dir])) {
					int ny = y + i * dy[dir];
					int nx = x + i * dx[dir];
					sum += graph[ny][nx];
				}
			}
		}
		return sum;
	}
	
	public static int result2(int y, int x) {
		int sum = graph[y][x];
		for(int i = 1; i < m; i++) {
			for (int dir = 0; dir < 4; dir++) {
				if (inRange(y + i * dys[dir], x + i * dxs[dir])) {
					int ny = y + i * dys[dir];
					int nx = x + i * dxs[dir];
					sum += graph[ny][nx];
				}
			}
		}
		return sum;
	}
}