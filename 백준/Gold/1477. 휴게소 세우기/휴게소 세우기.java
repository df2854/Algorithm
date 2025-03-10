/*
 접근 방법 : 백준 1654번 랜선 자르기 문제와 비슷하다. 랜선 자르기는 잘랐을때 나눠지는 개수, 휴게소 세우기는 휴게소 설치 수
 핵심 로직 : 각 구간 별 거리를 저장한 배열을 구현하여 이분 탐색
 시간 복잡도 : O(n * log L)
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n, m, l, result;
	static int[] arr, dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		// 출발점에서 첫 휴게소 거리 + 각 휴게소 거리 + 마지막 휴게소에서 도착점 거리
		dist = new int[n+1];
		
		if (n == 0) dist[0] = l;
		else {
			dist[0] = arr[0];
			for (int i = 1; i < n; i++) {
				dist[i] = arr[i] - arr[i-1];
			}
			dist[n] = l - arr[n-1];
		}
		
		// 1 <= 휴게소 위치 <= l - 1
		int left = 1, right = l - 1;
		
		result = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = 0;
			for (int num : dist) {
				count += (num - 1) / mid; // "count : 휴개소 설치 수"이므로 (num - 1) / mid
			}							// 예를 들어 거리가 9(num), 최대 허용 길이가 3(mid)일 때, 휴개소 설치 개수는 2 
			
			if (count > m) {
				left = mid + 1;
			} else {
				right = mid - 1;
				result = Math.min(result, mid);
			}
		}
		
		System.out.println(result);
 	}	
}