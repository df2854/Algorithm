/*
접근 방법 : 문제를 고르는 방법의 수 -> 부분 집합
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n, l, r, x, cnt;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine()); 
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		cnt = 0;
		
		for (int i = 0; i < (1 << n); i++) {
			int sum = 0;
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					list.add(arr[j]);
					sum += arr[j];
				}
			}
			if (list.size() >= 2) {
				if (sum >= l && sum <= r) {
					Collections.sort(list);
					int diff = list.get(list.size() - 1) - list.get(0);
					if (diff >= x) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}