/*
접근 방법 : dp 문제인데 어렵다.. -> 문제가 상승 비행과 하강 비행으로 나누어져있으니까 상승과 하강 2개로 나누어서 풀어보기 ->
상승 비행의 도착점과 하강 비행 출발점 dp 합이 가장 큰 것 -> 하강 비행 도착점에서부터 dp 갱신
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n, m, max;
	static int[][] map, dpUp, dpDown;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dpUp = new int[n][m]; // 상승 비행
		dpDown = new int[n][m]; // 하강 비행
		
		dpUp[n-1][0] = map[n-1][0]; // 왼쪽 아래에서 시작
		for (int i = n-1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if (i == n-1 && j == 0) continue; // 시작 위치 패스
				
				if (i == n-1) { // 제일 아래는 왼쪽에서만 온다
					dpUp[i][j] = dpUp[i][j-1] + map[i][j];
					continue;
				}
				
				if (j == 0) { // 제일 왼쪽은 아래에서만 온다
					dpUp[i][j] = dpUp[i+1][j] + map[i][j];
					continue;
				}
				
				// 나머지 칸은 왼쪽 or 아래에서 온다
				dpUp[i][j] = Math.max(dpUp[i+1][j], dpUp[i][j-1]) + map[i][j];
			}
		}
		
		dpDown[n-1][m-1] = map[n-1][m-1]; // 오른쪽 아래
		for (int i = n-1; i >= 0; i--) {
			for (int j = m-1; j >= 0; j--) {
				if (i == n-1 && j == m-1) continue; // 시작 위치 패스
				
				if (i == n-1) {
					dpDown[i][j] = dpDown[i][j+1] + map[i][j]; 
					continue;
				}
				
				if (j == m-1) {
					dpDown[i][j] = dpDown[i+1][j] + map[i][j];
					continue;
				}
				
				dpDown[i][j] = Math.max(dpDown[i+1][j], dpDown[i][j+1]) + map[i][j];
			}
		}
		
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, dpUp[i][j] + dpDown[i][j]);
			}
		}
		
		System.out.println(max);
	}
}
